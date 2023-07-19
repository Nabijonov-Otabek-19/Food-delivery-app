package uz.gita.fooddeliveryapp_bek.presentation.ui.screens.home

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.denzcoskun.imageslider.constants.ScaleTypes
import dagger.hilt.android.AndroidEntryPoint
import uz.gita.fooddeliveryapp_bek.R
import uz.gita.fooddeliveryapp_bek.databinding.ScreenHomeBinding
import uz.gita.fooddeliveryapp_bek.presentation.ui.adapters.MenuAdapter
import uz.gita.fooddeliveryapp_bek.presentation.ui.adapters.ProductAdapter
import uz.gita.fooddeliveryapp_bek.utils.categories
import uz.gita.fooddeliveryapp_bek.utils.toast
import javax.inject.Inject

@AndroidEntryPoint
class HomeScreen : Fragment(R.layout.screen_home) {

    private val binding by viewBinding(ScreenHomeBinding::bind)
    private val viewmodel by viewModels<HomeViewModelImpl>()

    @Inject
    lateinit var productAdapter: ProductAdapter

    @Inject
    lateinit var menuAdapter: MenuAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //val user = FirebaseAuth.getInstance().currentUser!!

        viewmodel.categoryData.observe(viewLifecycleOwner) {
            //categoryAdapter.setData(it)
            menuAdapter.setData(categories)
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

        viewmodel.offersData.observe(viewLifecycleOwner) {
            binding.imageSlider.setImageList(it, ScaleTypes.FIT)
        }

        productAdapter.setClickListener {
            findNavController().navigate(HomeScreenDirections.actionHomeScreenToDetailScreen(it))
        }

        menuAdapter.setOnItemClickListener {
            requireContext().toast(it.title)
        }


        binding.apply {

            recyclerFoods.layoutManager = LinearLayoutManager(requireContext())
            recyclerFoods.adapter = productAdapter

            recyclerCategory.layoutManager =
                GridLayoutManager(requireContext(), 4, RecyclerView.VERTICAL, false)
            recyclerCategory.adapter = menuAdapter

            /* recyclerCategory.layoutManager =
                 LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
             recyclerCategory.adapter = categoryAdapter*/

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