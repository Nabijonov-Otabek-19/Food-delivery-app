package uz.gita.fooddeliveryapp_bek.data.common

import uz.gita.fooddeliveryapp_bek.data.source.local.entity.ProductEntity
import java.io.Serializable

data class ProductData(
    val id: Int,
    val title: String,
    val description: String,
    val imgUrl: String,
    val price: Int,
    val category: String,
    var cart_count: Int = 0
) : Serializable {
    fun toEntity() = ProductEntity(id, title, description, imgUrl, price, category)
}