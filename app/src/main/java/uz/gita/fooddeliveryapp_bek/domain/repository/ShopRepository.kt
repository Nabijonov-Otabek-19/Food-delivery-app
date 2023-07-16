package uz.gita.fooddeliveryapp_bek.domain.repository

import kotlinx.coroutines.flow.Flow
import uz.gita.fooddeliveryapp_bek.data.common.CategoryData
import uz.gita.fooddeliveryapp_bek.data.common.FoodData

interface ShopRepository {

    fun getCategories(): Flow<Result<List<CategoryData>>>
    fun getFoods(): Flow<Result<List<FoodData>>>

    fun getProductsByCategory(categoryTitle: String): Flow<Result<List<FoodData>>>
}