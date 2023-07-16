package uz.gita.fooddeliveryapp_bek.presentation.ui.screens.signup

import androidx.lifecycle.LiveData

interface SignUpViewModel {

    val errorData: LiveData<String>
    val successData: LiveData<Unit>

    fun signUp(email: String, password: String)
}