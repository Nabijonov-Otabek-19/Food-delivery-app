package uz.gita.fooddeliveryapp_bek.data.common

data class MenuData(
    val id: Int,
    val icon : Int,
    val color : Int,
    val tintColor : Int = 0,
    val title: String
)