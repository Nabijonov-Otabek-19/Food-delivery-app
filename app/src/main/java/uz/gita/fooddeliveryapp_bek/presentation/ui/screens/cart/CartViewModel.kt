package uz.gita.fooddeliveryapp_bek.presentation.ui.screens.cart

import androidx.lifecycle.LiveData
import uz.gita.fooddeliveryapp_bek.data.common.ProductData

interface CartViewModel {

    val productsData: LiveData<List<ProductData>>
    val errorData: LiveData<String>
    val loadingData: LiveData<Boolean>

    fun getCartProducts()
    fun removeFromCart(productData: ProductData)
}