package uz.gita.fooddeliveryapp_bek.presentation.ui.screens.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import uz.gita.fooddeliveryapp_bek.data.common.CategoryData
import uz.gita.fooddeliveryapp_bek.data.common.FoodData
import uz.gita.fooddeliveryapp_bek.domain.repository.ShopRepository
import uz.gita.fooddeliveryapp_bek.domain.repository.impl.ShopRepositoryImpl

class HomeViewModelImpl : HomeViewModel, ViewModel() {

    private val shopRepository: ShopRepository = ShopRepositoryImpl()

    override val errorData = MutableLiveData<String>()
    override val loadingData = MutableLiveData<Boolean>()
    override val categoryData = MutableLiveData<List<CategoryData>>()
    override val foodsData = MutableLiveData<List<FoodData>>()

    init {
        getAllData()
    }

    override fun getAllData() {
        loadingData.value = true
        shopRepository.getCategories().onEach { data ->
            data.onSuccess { categoryData.value = it }
            data.onFailure { errorData.value = it.message }
        }.launchIn(viewModelScope)

        shopRepository.getFoods().onEach { data ->
            data.onSuccess {
                loadingData.value = false
                foodsData.value = it
            }
            data.onFailure {
                loadingData.value = false
                errorData.value = it.message
            }
        }.launchIn(viewModelScope)
    }

    override fun getFoodsByCategory(categoryName: String) {
        loadingData.value = true
        shopRepository.getProductsByCategory(categoryName).onEach { data ->
            data.onSuccess {
                loadingData.value = false
                foodsData.value = it
            }
            data.onFailure {
                loadingData.value = false
                errorData.value = it.message
            }
        }.launchIn(viewModelScope)
    }
}