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

val categoryBolimlar = listOf(
    MenuData(1, R.drawable.ic_book, R.color.white, 0, "Kitoblar"),
    MenuData(2, R.drawable.ic_phone, R.color.white, 0, "Telefonlar va gadjetlar"),
    MenuData(3, R.drawable.ic_wash_machine, R.color.white, 0, "Maishiy texnika"),
    MenuData(4, R.drawable.ic_conditioner, R.color.white, 0, "Iqlim texnikasi"),
    MenuData(5, R.drawable.ic_computer, R.color.white, 0, "Kompyuter texnikasi"),
    MenuData(6, R.drawable.ic_sport, R.color.white, 0, "Sport va dam olish"),
    MenuData(7, R.drawable.ic_ladder, R.color.white, 0, "Uy va ofis uchun tovarlar"),
    MenuData(8, R.drawable.ic_tv, R.color.white, 0, "Televizor, video va audio"),
    MenuData(9, R.drawable.ic_joystick, R.color.white, 0, "Geymerlar uchun tovarlar"),
    MenuData(10, R.drawable.ic_sofa, R.color.white, 0, "Mebel"),
    MenuData(11, R.drawable.ic_pan, R.color.white, 0, "Idish-tovoqlar"),
    MenuData(12, R.drawable.ic_parfume, R.color.white, 0, "Go'zallik va salomatlik"),
    MenuData(13, R.drawable.ic_bear, R.color.white, 0, "Bolalar uchun tovarlar"),
    MenuData(14, R.drawable.ic_tshirt, R.color.white, 0, "Kiyim, poyabzal va aksessuarlar"),
    MenuData(15, R.drawable.ic_gift, R.color.white, 0, "O'yinchoqlar, sovg'alar va aksessuarlar"),
    MenuData(16, R.drawable.ic_wheel, R.color.white, 0, "Avto mollari")
)
