package uz.gita.fooddeliveryapp_bek.presentation.ui.screens.signin

import androidx.lifecycle.LiveData
import kotlinx.coroutines.flow.Flow
import uz.gita.fooddeliveryapp_bek.data.common.CategoryData
import uz.gita.fooddeliveryapp_bek.data.common.FoodData

interface SignInViewModel {

    val errorData: LiveData<String>
    fun signIn(email: String, password: String)
}