package uz.gita.fooddeliveryapp_bek.presentation.ui.screens.cart

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import uz.gita.fooddeliveryapp_bek.R
import uz.gita.fooddeliveryapp_bek.databinding.ScreenCartBinding

@AndroidEntryPoint
class CartScreen : Fragment(R.layout.screen_cart) {

    private val binding by viewBinding(ScreenCartBinding::bind)
    private val viewModel by viewModels<CartViewModelImpl>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }
}