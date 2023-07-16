package uz.gita.fooddeliveryapp_bek.presentation.ui.screens.home

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.denzcoskun.imageslider.constants.ScaleTypes
import dagger.hilt.android.AndroidEntryPoint
import uz.gita.fooddeliveryapp_bek.R
import uz.gita.fooddeliveryapp_bek.databinding.HomeScreenBinding
import uz.gita.fooddeliveryapp_bek.presentation.ui.adapters.CategoryAdapter
import uz.gita.fooddeliveryapp_bek.presentation.ui.adapters.ProductAdapter
import javax.inject.Inject

@AndroidEntryPoint
class HomeScreen : Fragment(R.layout.home_screen) {

    private val binding by viewBinding(HomeScreenBinding::bind)
    private val viewmodel by viewModels<HomeViewModelImpl>()

    @Inject
    lateinit var productAdapter: ProductAdapter

    @Inject
    lateinit var categoryAdapter: CategoryAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //val user = FirebaseAuth.getInstance().currentUser!!

        viewmodel.categoryData.observe(viewLifecycleOwner) {
            categoryAdapter.setData(it)
        }

        viewmodel.loadingData.observe(viewLifecycleOwner) {
            val visibility = if (it) View.VISIBLE else View.GONE
            binding.progressBar.visibility = visibility
        }

        viewmodel.errorData.observe(viewLifecycleOwner) {
            Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
        }

        viewmodel.foodsData.observe(viewLifecycleOwner) {
            productAdapter.setData(it)
        }

        categoryAdapter.setClickListener {
            viewmodel.getFoodsByCategory(it)
        }

        productAdapter.setClickListener {
            findNavController().navigate(HomeScreenDirections.actionHomeScreenToDetailScreen(it))
        }

        viewmodel.offersData.observe(viewLifecycleOwner) {
            binding.imageSlider.setImageList(it, ScaleTypes.FIT)
        }

        binding.apply {

            recyclerFoods.layoutManager = LinearLayoutManager(requireContext())
            recyclerFoods.adapter = productAdapter

            recyclerCategory.layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            recyclerCategory.adapter = categoryAdapter

            /* recyclerFoods.addOnScrollListener(object : RecyclerView.OnScrollListener() {
                 override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                     super.onScrollStateChanged(recyclerView, newState)
                     if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                         // Get the first visible item position in the second RecyclerView
                         val firstVisibleItemPosition =
                             (recyclerView.layoutManager as LinearLayoutManager).findFirstVisibleItemPosition()

                         // Scroll the first RecyclerView to the corresponding category item position
                         recyclerCategory.scrollToPosition(firstVisibleItemPosition)
                     }
                 }
             })*/


            /*  val credential = EmailAuthProvider.getCredential(user.email.toString(), "123456")

              btnLogout.setOnClickListener {
                  user.reauthenticate(credential).addOnCompleteListener {
                      user.delete().addOnCompleteListener {
                          if (it.isSuccessful) {
                              Toast.makeText(requireContext(), "User deleted", Toast.LENGTH_SHORT)
                                  .show()
                              findNavController().popBackStack()
                              findNavController().navigate(R.id.signUpScreen)
                          } else {
                              Toast.makeText(
                                  requireContext(),
                                  "${it.exception?.message}",
                                  Toast.LENGTH_SHORT
                              )
                                  .show()
                          }
                      }
                  }
              }*/
        }
    }
}