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

    override fun checkFavProduct(productId: Int): Boolean =
        roomRepository.checkFavProduct(productId)

    override fun saveToFav(productData: ProductData) {
        roomRepository.saveToFav(productData)
    }

    override fun removeFromFav(productData: ProductData) {
        roomRepository.removeFromFav(productData)
    }

    override fun checkCartProduct(productId: Int): Boolean =
        roomRepository.checkCartProduct(productId)

    override fun saveToCart(productData: ProductData) {
        roomRepository.saveToCart(productData)
    }

    override fun removeFromCart(productData: ProductData) {
        roomRepository.removeFromCart(productData)
    }
}