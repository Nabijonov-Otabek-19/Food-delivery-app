package uz.gita.fooddeliveryapp_bek.domain.repository

import kotlinx.coroutines.flow.Flow
import uz.gita.fooddeliveryapp_bek.data.common.ProductData

interface RoomRepository {

    fun updateCartProduct(productData: ProductData)
    fun getTotalPrice(): Long

    fun checkFavProduct(productId: Int): Boolean
    fun checkCartProduct(productId: Int): Boolean

    fun saveToFav(productData: ProductData)
    fun removeFromFav(productData: ProductData)

    fun saveToCart(productData: ProductData)
    fun removeFromCart(productData: ProductData)

    fun getFavouriteProducts(): Flow<List<ProductData>>
    fun getCartProducts(): Flow<List<ProductData>>
}