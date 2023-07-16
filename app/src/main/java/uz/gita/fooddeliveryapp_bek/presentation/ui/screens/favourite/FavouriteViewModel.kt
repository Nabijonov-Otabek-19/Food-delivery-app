package uz.gita.fooddeliveryapp_bek.presentation.ui.screens.favourite

import androidx.lifecycle.LiveData
import uz.gita.fooddeliveryapp_bek.data.common.ProductData

interface FavouriteViewModel {

    val productsData: LiveData<List<ProductData>>
    val errorData: LiveData<String>
    val loadingData: LiveData<Boolean>

    fun getFavouriteProducts()
}