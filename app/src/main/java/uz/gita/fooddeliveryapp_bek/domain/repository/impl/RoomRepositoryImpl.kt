package uz.gita.fooddeliveryapp_bek.domain.repository.impl

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import uz.gita.fooddeliveryapp_bek.data.common.ProductData
import uz.gita.fooddeliveryapp_bek.data.source.local.dao.ProductDao
import uz.gita.fooddeliveryapp_bek.domain.repository.RoomRepository
import javax.inject.Inject

class RoomRepositoryImpl @Inject constructor(
    private val dao: ProductDao
) : RoomRepository {

    override fun checkFavProduct(productId: Int): Boolean = dao.checkFavProduct(productId)
    override fun checkCartProduct(productId: Int): Boolean = dao.checkCartProduct(productId)

    override fun saveToFav(productData: ProductData) {
        dao.addFav(productData.toFavEntity())
    }

    override fun removeFromFav(productData: ProductData) {
        dao.deleteFav(productData.toFavEntity())
    }

    override fun saveToCart(productData: ProductData) {
        dao.addCart(productData.toCartEntity())
    }

    override fun removeFromCart(productData: ProductData) {
        dao.deleteCart(productData.toCartEntity())
    }

    override fun getFavouriteProducts(): Flow<List<ProductData>> =
        dao.getFavouriteProducts().map { list ->
            list.map { data -> data.toData() }
        }

    override fun getCartProducts(): Flow<List<ProductData>> =
        dao.getCartProducts().map { list ->
            list.map { data -> data.toData() }
        }
}