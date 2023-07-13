package uz.gita.fooddeliveryapp_bek.utils

import android.content.Context
import android.util.Log
import android.widget.Toast


fun Context.toast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

fun logger(message: String) {
    Log.d("AAA", message)
}
