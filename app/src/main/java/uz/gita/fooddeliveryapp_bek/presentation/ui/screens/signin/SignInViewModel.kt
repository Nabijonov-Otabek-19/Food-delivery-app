package uz.gita.fooddeliveryapp_bek.presentation.ui.screens.signin

import androidx.lifecycle.LiveData

interface SignInViewModel {

    val errorData: LiveData<String>
    fun signIn(email: String, password: String)
}