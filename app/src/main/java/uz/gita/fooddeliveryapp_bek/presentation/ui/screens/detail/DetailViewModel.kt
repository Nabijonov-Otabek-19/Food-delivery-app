package uz.gita.fooddeliveryapp_bek.presentation.ui.screens.detail

import uz.gita.fooddeliveryapp_bek.data.common.ProductData

interface DetailViewModel {

    fun checkProduct(productId: Int): Boolean
    fun saveToDB(productData: ProductData)
    fun removeFromDB(productData: ProductData)
}