package uz.gita.fooddeliveryapp_bek.utils

import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

object UserData {
    var user = Firebase.auth.currentUser
}