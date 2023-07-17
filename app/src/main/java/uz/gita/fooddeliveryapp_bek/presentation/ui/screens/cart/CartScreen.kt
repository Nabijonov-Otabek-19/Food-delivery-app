package uz.gita.fooddeliveryapp_bek.presentation.ui.screens.cart

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import uz.gita.fooddeliveryapp_bek.R
import uz.gita.fooddeliveryapp_bek.databinding.ScreenCartBinding
import uz.gita.fooddeliveryapp_bek.presentation.ui.adapters.CartAdapter
import uz.gita.fooddeliveryapp_bek.utils.logger
import javax.inject.Inject

@AndroidEntryPoint
class CartScreen : Fragment(R.layout.screen_cart) {

    private val binding by viewBinding(ScreenCartBinding::bind)
    private val viewModel by viewModels<CartViewModelImpl>()

    @Inject
    lateinit var adapter: CartAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.errorData.observe(viewLifecycleOwner) {
            logger("CartScreen error = $it")
        }

        viewModel.loadingData.observe(viewLifecycleOwner) {
            binding.progressBar.visibility = if (it) View.VISIBLE else View.GONE
        }

        viewModel.totalPriceData.observe(viewLifecycleOwner) {
            binding.txtTotal.text = "$it sum"
        }

        viewModel.productsData.observe(viewLifecycleOwner) {
            if (it.isEmpty()) {
                binding.apply {
                    imgNoData.visibility = View.VISIBLE
                    recyclerCart.visibility = View.GONE
                    container.visibility = View.GONE
                }
            } else {
                binding.apply {
                    imgNoData.visibility = View.GONE
                    recyclerCart.visibility = View.VISIBLE
                    container.visibility = View.VISIBLE
                }
                adapter.setData(it)
            }
        }

        adapter.apply {
            setMinusClickListener {
                viewModel.updateCart(it)
                viewModel.getTotalPrice()
            }

            setPlusClickListener {
                viewModel.updateCart(it)
                viewModel.getTotalPrice()
            }

            setRemoveClickListener {
                viewModel.removeFromCart(it)
                viewModel.getTotalPrice()
            }
        }

        binding.apply {
            recyclerCart.layoutManager = LinearLayoutManager(requireContext())
            recyclerCart.adapter = adapter

            btnOrder.setOnClickListener {

            }
        }
    }
}