package uz.gita.fooddeliveryapp_bek.domain.repository

import kotlinx.coroutines.flow.Flow
import uz.gita.fooddeliveryapp_bek.data.common.ProductData

interface RoomRepository {

    fun checkProduct(productId: Int): Boolean
    fun saveToDB(productData: ProductData)
    fun removeFromDB(productData: ProductData)

    fun getFavouriteProducts(): Flow<List<ProductData>>
}