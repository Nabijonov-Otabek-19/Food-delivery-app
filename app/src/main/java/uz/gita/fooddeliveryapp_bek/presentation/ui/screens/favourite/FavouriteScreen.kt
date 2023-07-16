package uz.gita.fooddeliveryapp_bek.presentation.ui.screens.favourite

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import uz.gita.fooddeliveryapp_bek.R
import uz.gita.fooddeliveryapp_bek.databinding.FavouriteScreenBinding
import uz.gita.fooddeliveryapp_bek.presentation.ui.adapters.ProductAdapter
import uz.gita.fooddeliveryapp_bek.utils.toast
import javax.inject.Inject

@AndroidEntryPoint
class FavouriteScreen : Fragment(R.layout.favourite_screen) {

    private val binding by viewBinding(FavouriteScreenBinding::bind)
    private val viewmodel by viewModels<FavouriteViewModelImpl>()

    @Inject
    lateinit var adapter: ProductAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewmodel.getFavouriteProducts()

        viewmodel.loadingData.observe(viewLifecycleOwner) {
            binding.progressBar.visibility = if (it) View.VISIBLE else View.GONE
        }

        viewmodel.errorData.observe(viewLifecycleOwner) {
            requireContext().toast("Favourite error = $it")
        }

        viewmodel.productsData.observe(viewLifecycleOwner) {
            if (it.isEmpty()) {
                binding.apply {
                    imgNoData.visibility = View.VISIBLE
                    recyclerFavourites.visibility = View.GONE
                }
            } else {
                binding.apply {
                    imgNoData.visibility = View.GONE
                    recyclerFavourites.visibility = View.VISIBLE
                }
                adapter.setData(it)
            }
        }

        adapter.setClickListener {
            findNavController().navigate(
                FavouriteScreenDirections.actionFavouriteScreenToDetailScreen(it)
            )
        }

        binding.apply {
            recyclerFavourites.layoutManager = LinearLayoutManager(requireContext())
            recyclerFavourites.adapter = adapter
        }
    }
}