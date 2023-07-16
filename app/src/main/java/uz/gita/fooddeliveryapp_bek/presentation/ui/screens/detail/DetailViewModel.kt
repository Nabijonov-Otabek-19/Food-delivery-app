package uz.gita.fooddeliveryapp_bek.presentation.ui.screens.detail

import uz.gita.fooddeliveryapp_bek.data.common.ProductData

interface DetailViewModel {

    fun checkFavProduct(productId: Int): Boolean
    fun saveToFav(productData: ProductData)
    fun removeFromFav(productData: ProductData)

    fun checkCartProduct(productId: Int): Boolean
    fun saveToCart(productData: ProductData)
    fun removeFromCart(productData: ProductData)
}