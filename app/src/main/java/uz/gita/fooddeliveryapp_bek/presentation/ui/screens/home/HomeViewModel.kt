package uz.gita.fooddeliveryapp_bek.presentation.ui.screens.home

import androidx.lifecycle.LiveData
import uz.gita.fooddeliveryapp_bek.data.common.CategoryData
import uz.gita.fooddeliveryapp_bek.data.common.ProductData

interface HomeViewModel {

    val errorData : LiveData<String>
    val loadingData : LiveData<Boolean>
    val categoryData: LiveData<List<CategoryData>>
    val foodsData: LiveData<List<ProductData>>

    fun getAllData()
    fun getFoodsByCategory(categoryName: String)
}