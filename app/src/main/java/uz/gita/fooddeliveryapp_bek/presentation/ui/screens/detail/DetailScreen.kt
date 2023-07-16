package uz.gita.fooddeliveryapp_bek.presentation.ui.screens.detail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import dagger.hilt.android.AndroidEntryPoint
import uz.gita.fooddeliveryapp_bek.R
import uz.gita.fooddeliveryapp_bek.databinding.DetailScreenBinding

@AndroidEntryPoint
class DetailScreen : Fragment(R.layout.detail_screen) {

    private val binding by viewBinding(DetailScreenBinding::bind)
    private val viewmodel by viewModels<DetailViewModelImpl>()
    private val args by navArgs<DetailScreenArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val productData = args.productData

        binding.apply {
            btnBack.setOnClickListener {
                findNavController().popBackStack()
            }

            txtTitle.text = productData.title
            txtCategory.text = productData.category
            txtPrice.text = productData.price.toString()

            Glide.with(requireContext()).load(productData.imgUrl).into(idImgProduct)

            if (viewmodel.checkProduct(productData.id)) {
                btnFavourite.setImageResource(R.drawable.ic_love_full)
            } else {
                btnFavourite.setImageResource(R.drawable.ic_love)
            }

            btnFavourite.setOnClickListener {
                if (viewmodel.checkProduct(productData.id)) {
                    viewmodel.removeFromDB(productData)
                    btnFavourite.setImageResource(R.drawable.ic_love)
                } else {
                    viewmodel.saveToDB(productData)
                    btnFavourite.setImageResource(R.drawable.ic_love_full)
                }
            }

            btnAdd2Cart.setOnClickListener {

            }
        }
    }
}