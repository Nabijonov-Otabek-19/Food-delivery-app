package uz.gita.fooddeliveryapp_bek.domain.repository

import com.denzcoskun.imageslider.models.SlideModel
import kotlinx.coroutines.flow.Flow
import uz.gita.fooddeliveryapp_bek.data.common.CategoryData
import uz.gita.fooddeliveryapp_bek.data.common.ProductData

interface ShopRepository {

    fun getCategories(): Flow<Result<List<CategoryData>>>
    fun getFoods(): Flow<Result<List<ProductData>>>
    fun getOffers(): Flow<Result<List<SlideModel>>>

    fun getProductsByCategory(categoryTitle: String): Flow<Result<List<ProductData>>>
}