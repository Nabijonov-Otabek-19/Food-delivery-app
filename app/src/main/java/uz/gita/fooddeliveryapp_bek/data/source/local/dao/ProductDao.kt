package uz.gita.fooddeliveryapp_bek.data.source.local.dao

import androidx.room.*
import kotlinx.coroutines.flow.Flow
import uz.gita.fooddeliveryapp_bek.data.source.local.entity.ProductEntity

@Dao
interface ProductDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun add(productEntity: ProductEntity)

    @Delete
    fun delete(productEntity: ProductEntity)

    @Update
    fun update(productEntity: ProductEntity)

    @Query("Select * from products")
    fun getFavouriteProducts(): Flow<List<ProductEntity>>

    @Query("Select exists (Select * from products Where id =:productId)")
    fun checkProduct(productId: Int): Boolean
}