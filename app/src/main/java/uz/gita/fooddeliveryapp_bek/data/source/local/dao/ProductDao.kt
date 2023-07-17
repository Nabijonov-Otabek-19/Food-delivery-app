package uz.gita.fooddeliveryapp_bek.data.source.local.dao

import androidx.room.*
import kotlinx.coroutines.flow.Flow
import uz.gita.fooddeliveryapp_bek.data.source.local.entity.CartProductEntity
import uz.gita.fooddeliveryapp_bek.data.source.local.entity.FavProductEntity

@Dao
interface ProductDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addFav(favProductEntity: FavProductEntity)

    @Delete
    fun deleteFav(favProductEntity: FavProductEntity)

    @Query("Select * from favproducts")
    fun getFavouriteProducts(): Flow<List<FavProductEntity>>

    @Query("Select exists (Select * from favproducts Where id =:productId)")
    fun checkFavProduct(productId: Int): Boolean

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addCart(cartProductEntity: CartProductEntity)

    @Delete
    fun deleteCart(cartProductEntity: CartProductEntity)

    @Update
    fun updateCart(cartProductEntity: CartProductEntity)

    @Query("Select * from cartproducts")
    fun getCartProducts(): Flow<List<CartProductEntity>>

    @Query("Select exists (Select * from cartproducts Where id =:productId)")
    fun checkCartProduct(productId: Int): Boolean

    @Query("SELECT SUM(price * cart_count) as totalSum FROM cartproducts")
    fun getTotalSum(): Long
}