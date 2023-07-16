package uz.gita.fooddeliveryapp_bek.presentation.ui.screens.signin

import androidx.lifecycle.LiveData

interface SignInViewModel {

    val errorData: LiveData<String>
    val successData: LiveData<Unit>

    fun signIn(email: String, password: String)
}