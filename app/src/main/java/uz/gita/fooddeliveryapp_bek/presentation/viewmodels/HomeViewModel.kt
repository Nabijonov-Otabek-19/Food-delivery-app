package uz.gita.fooddeliveryapp_bek.presentation.viewmodels

import androidx.lifecycle.LiveData
import uz.gita.fooddeliveryapp_bek.data.common.CategoryData
import uz.gita.fooddeliveryapp_bek.data.common.FoodData

interface HomeViewModel {

    val errorData : LiveData<String>
    val loadingData : LiveData<Boolean>
    val categoryData: LiveData<List<CategoryData>>
    val foodsData: LiveData<List<FoodData>>

    fun getAllData()
    fun getFoodsByCategory(categoryName: String)
}