package uz.gita.fooddeliveryapp_bek.data.source.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import uz.gita.fooddeliveryapp_bek.data.common.ProductData

@Entity(tableName = "products")
data class ProductEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    val description: String,
    val imgUrl: String,
    val price: Int,
    val category: String,
    var cart_count: Int = 0
) {
    fun toData() = ProductData(id, title, description, imgUrl, price, category)
}