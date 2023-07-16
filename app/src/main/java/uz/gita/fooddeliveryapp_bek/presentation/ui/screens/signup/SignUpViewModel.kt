package uz.gita.fooddeliveryapp_bek.presentation.ui.screens.signup

import androidx.lifecycle.LiveData
import kotlinx.coroutines.flow.Flow
import uz.gita.fooddeliveryapp_bek.data.common.CategoryData
import uz.gita.fooddeliveryapp_bek.data.common.FoodData

interface SignUpViewModel {

    val errorData: LiveData<String>
    fun signUp(email: String, password: String)
}