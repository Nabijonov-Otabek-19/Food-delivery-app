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

    override fun checkProduct(productId: Int): Boolean = dao.checkProduct(productId)

    override fun saveToDB(productData: ProductData) {
        dao.add(productData.toEntity())
    }

    override fun removeFromDB(productData: ProductData) {
        dao.delete(productData.toEntity())
    }

    override fun getFavouriteProducts(): Flow<List<ProductData>> =
        dao.getFavouriteProducts().map { list ->
            list.map { data -> data.toData() }
        }
}