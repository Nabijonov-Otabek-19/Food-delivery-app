package uz.gita.fooddeliveryapp_bek.utils

import android.content.Context
import android.util.Log
import android.widget.Toast
import uz.gita.fooddeliveryapp_bek.R
import uz.gita.fooddeliveryapp_bek.data.common.MenuData


fun Context.toast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

fun logger(message: String) {
    Log.d("AAA", message)
}

val categories = listOf(
    MenuData(
        1, R.drawable.ic_category, R.color.light_blue,
        R.color.colorPrimary, "Bo'limlar"
    ),
    MenuData(
        2, R.drawable.ic_calendar, R.color.light_red,
        R.color.red, "Muddatli to'lov"
    ),
    MenuData(
        3, R.drawable.ic_discount, R.color.light_pink,
        R.color.pink, "Chegirmalar"
    ),
    MenuData(
        4, R.drawable.ic_lighting, R.color.light_orange,
        R.color.orange, "Yangilar"
    ),
    MenuData(4, R.drawable.ic_book, R.color.white, 0, "Kitoblar"),
    MenuData(4, R.drawable.ic_phone, R.color.white, 0, "Telefonlar va gadjetlar"),
    MenuData(4, R.drawable.ic_wash_machine, R.color.white, 0, "Maishiy texnika"),
    MenuData(4, R.drawable.ic_conditioner, R.color.white, 0, "Iqlim texnikasi")
)
