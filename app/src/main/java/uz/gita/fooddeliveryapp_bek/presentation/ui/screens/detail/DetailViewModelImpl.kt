package uz.gita.fooddeliveryapp_bek.presentation.ui.screens.detail

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import uz.gita.fooddeliveryapp_bek.data.common.ProductData
import uz.gita.fooddeliveryapp_bek.domain.repository.RoomRepository
import javax.inject.Inject

@HiltViewModel
class DetailViewModelImpl @Inject constructor(
    private val roomRepository: RoomRepository
) : DetailViewModel, ViewModel() {

    override fun checkProduct(productId: Int): Boolean = roomRepository.checkProduct(productId)

    override fun saveToDB(productData: ProductData) {
        roomRepository.saveToDB(productData)
    }

    override fun removeFromDB(productData: ProductData) {
        roomRepository.removeFromDB(productData)
    }
}