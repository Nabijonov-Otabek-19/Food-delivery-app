package uz.gita.fooddeliveryapp_bek.presentation.ui.screens.signup

import androidx.lifecycle.LiveData

interface SignUpViewModel {

    val errorData: LiveData<String>
    fun signUp(email: String, password: String)
}