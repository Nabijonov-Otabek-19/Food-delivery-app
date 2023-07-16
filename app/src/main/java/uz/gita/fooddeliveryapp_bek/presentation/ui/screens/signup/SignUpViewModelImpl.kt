package uz.gita.fooddeliveryapp_bek.presentation.ui.screens.signup

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import uz.gita.fooddeliveryapp_bek.domain.repository.AuthRepository
import javax.inject.Inject

@HiltViewModel
class SignUpViewModelImpl @Inject constructor(
    private val authRepository: AuthRepository
) : SignUpViewModel, ViewModel() {

    override val errorData = MutableLiveData<String>()
    override val successData = MutableLiveData<Unit>()

    override fun signUp(email: String, password: String) {
        authRepository.signUp(email, password).onEach { result ->
            result.onSuccess { successData.value = it }
            result.onFailure { errorData.value = it.message }
        }.launchIn(viewModelScope)
    }
}