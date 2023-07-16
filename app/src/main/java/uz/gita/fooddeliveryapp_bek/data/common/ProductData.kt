package uz.gita.fooddeliveryapp_bek.data.common

import uz.gita.fooddeliveryapp_bek.data.source.local.entity.CartProductEntity
import uz.gita.fooddeliveryapp_bek.data.source.local.entity.FavProductEntity
import java.io.Serializable

data class ProductData(
    val id: Int = 0,
    val title: String = "",
    val description: String = "",
    val imgUrl: String = "",
    val price: Int = 0,
    val category: String = "",
    var cart_count: Int = 0
) : Serializable {
    fun toFavEntity() =
        FavProductEntity(id, title, description, imgUrl, price, category, cart_count)

    fun toCartEntity() =
        CartProductEntity(id, title, description, imgUrl, price, category, cart_count)
}