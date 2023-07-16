package uz.gita.fooddeliveryapp_bek.domain.repository.impl

import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import uz.gita.fooddeliveryapp_bek.data.common.CategoryData
import uz.gita.fooddeliveryapp_bek.data.common.ProductData
import uz.gita.fooddeliveryapp_bek.domain.repository.ShopRepository
import javax.inject.Inject

class ShopRepositoryImpl @Inject constructor() : ShopRepository {

    private val firestore = Firebase.firestore

    override fun getCategories()
            : Flow<Result<List<CategoryData>>> = callbackFlow {

        firestore.collection("category").get()
            .addOnSuccessListener { query ->
                val list = arrayListOf<CategoryData>()
                query.forEach { categories ->
                    list.add(categories.toObject() as CategoryData)
                }
                trySend(Result.success(list))
            }
            .addOnFailureListener {
                trySend(Result.failure(it))
            }
        awaitClose()
    }

    override fun getFoods(): Flow<Result<List<ProductData>>> = callbackFlow {
        firestore.collection("foods").get()
            .addOnSuccessListener { query ->
                val list = arrayListOf<ProductData>()
                query.forEach { foods ->
                    list.add(foods.toObject() as ProductData)
                }
                trySend(Result.success(list))
            }
            .addOnFailureListener {
                trySend(Result.failure(it))
            }
        awaitClose()
    }

    override fun getOffers(): Flow<Result<List<SlideModel>>> = callbackFlow {
        firestore.collection("offers").get()
            .addOnSuccessListener { query ->
                val list = arrayListOf<SlideModel>()
                query.forEach { offers ->
                    val offer = offers.getString("imgUrl")
                    list.add(SlideModel(offer, ScaleTypes.FIT))
                }
                trySend(Result.success(list))
            }
            .addOnFailureListener { trySend(Result.failure(it)) }
        awaitClose()
    }

    override fun getProductsByCategory(categoryTitle: String)
            : Flow<Result<List<ProductData>>> = callbackFlow {

        if (categoryTitle == "All") {
            firestore.collection("foods").get()
                .addOnSuccessListener { query ->
                    val list = arrayListOf<ProductData>()
                    query.forEach { foods ->
                        val food = foods.toObject<ProductData>()
                        list.add(food)
                    }
                    trySend(Result.success(list))
                }
                .addOnFailureListener { trySend(Result.failure(it)) }

        } else {
            firestore.collection("foods")
                .whereEqualTo("category", categoryTitle).get()
                .addOnSuccessListener { query ->
                    val list = arrayListOf<ProductData>()
                    query.forEach { foods ->
                        val food = foods.toObject<ProductData>()
                        list.add(food)
                    }
                    trySend(Result.success(list))
                }
                .addOnFailureListener { trySend(Result.failure(it)) }
        }

        awaitClose()
    }
}