package uz.gita.fooddeliveryapp_bek.presentation.ui.screens.favourite

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import uz.gita.fooddeliveryapp_bek.data.common.ProductData
import uz.gita.fooddeliveryapp_bek.domain.repository.RoomRepository
import javax.inject.Inject

@HiltViewModel
class FavouriteViewModelImpl @Inject constructor(
    private val roomRepository: RoomRepository
) : FavouriteViewModel, ViewModel() {

    override val productsData = MutableLiveData<List<ProductData>>()
    override val errorData = MutableLiveData<String>()
    override val loadingData = MutableLiveData<Boolean>()

    override fun getFavouriteProducts() {
        loadingData.value = true
        roomRepository.getFavouriteProducts().onEach { data ->
            loadingData.value = false
            productsData.value = data
        }.launchIn(viewModelScope)
    }
}