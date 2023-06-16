package uz.gita.fooddeliveryapp_bek.repository.impl

import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import uz.gita.fooddeliveryapp_bek.data.common.CategoryData
import uz.gita.fooddeliveryapp_bek.data.common.FoodData
import uz.gita.fooddeliveryapp_bek.repository.ShopRepository

class ShopRepositoryImpl : ShopRepository {

    private val firestore = Firebase.firestore

    override fun getCategories()
            : Flow<Result<List<CategoryData>>> = callbackFlow {

        firestore.collection("category").get()
            .addOnSuccessListener { query ->
                val list = arrayListOf<CategoryData>()
                query.forEach { categories ->
                    val category = CategoryData(title = categories.get("title").toString())
                    list.add(category)
                }
                trySend(Result.success(list))
            }
            .addOnFailureListener {
                trySend(Result.failure(it))
            }
        awaitClose()
    }

    override fun getFoods(): Flow<Result<List<FoodData>>> = callbackFlow {

        firestore.collection("foods").get()
            .addOnSuccessListener { query ->
                val list = arrayListOf<FoodData>()
                query.forEach { foods ->
                    val food = FoodData(
                        title = foods.get("title").toString(),
                        description = foods.get("description").toString(),
                        imgUrl = foods.get("imgUrl").toString(),
                        price = foods.get("price").toString().toInt(),
                        category = foods.get("category").toString()
                    )
                    list.add(food)
                }
                trySend(Result.success(list))
            }
            .addOnFailureListener {
                trySend(Result.failure(it))
            }
        awaitClose()
    }

    override fun getProductsByCategory(categoryTitle: String)
            : Flow<Result<List<FoodData>>> = callbackFlow {

        if (categoryTitle == "All") {
            firestore.collection("foods").get()
                .addOnSuccessListener { query ->
                    val list = arrayListOf<FoodData>()
                    query.forEach { foods ->
                        val food = FoodData(
                            title = foods.get("title").toString(),
                            description = foods.get("description").toString(),
                            imgUrl = foods.get("imgUrl").toString(),
                            price = foods.get("price").toString().toInt(),
                            category = foods.get("category").toString()
                        )
                        list.add(food)
                    }
                    trySend(Result.success(list))
                }
                .addOnFailureListener {
                    trySend(Result.failure(it))
                }

        } else {
            firestore.collection("foods")
                .whereEqualTo("category", categoryTitle).get()
                .addOnSuccessListener { query ->
                    val list = arrayListOf<FoodData>()
                    query.forEach { foods ->
                        val food = FoodData(
                            title = foods.get("title").toString(),
                            description = foods.get("description").toString(),
                            imgUrl = foods.get("imgUrl").toString(),
                            price = foods.get("price").toString().toInt(),
                            category = foods.get("category").toString()
                        )
                        list.add(food)
                    }
                    trySend(Result.success(list))
                }
                .addOnFailureListener {
                    trySend(Result.failure(it))
                }
        }

        awaitClose()
    }
}