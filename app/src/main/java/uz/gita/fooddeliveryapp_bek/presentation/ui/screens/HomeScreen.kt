package uz.gita.fooddeliveryapp_bek.presentation.ui.screens

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.google.firebase.auth.EmailAuthProvider
import com.google.firebase.auth.FirebaseAuth
import uz.gita.fooddeliveryapp_bek.R
import uz.gita.fooddeliveryapp_bek.databinding.HomeScreenBinding
import uz.gita.fooddeliveryapp_bek.presentation.ui.adapters.CategoryAdapter
import uz.gita.fooddeliveryapp_bek.presentation.ui.adapters.FoodsAdapter
import uz.gita.fooddeliveryapp_bek.presentation.viewmodels.impl.HomeViewModelImpl

class HomeScreen : Fragment(R.layout.home_screen) {

    private val binding by viewBinding(HomeScreenBinding::bind)
    private val viewmodel by viewModels<HomeViewModelImpl>()
    private val foodsAdapter by lazy { FoodsAdapter() }
    private val categoryAdapter by lazy { CategoryAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val user = FirebaseAuth.getInstance().currentUser!!

        viewmodel.categoryData.observe(viewLifecycleOwner) {
            categoryAdapter.setData(it)
        }

        viewmodel.errorData.observe(viewLifecycleOwner) {
            Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
        }

        viewmodel.foodsData.observe(viewLifecycleOwner) {
            foodsAdapter.setData(it)
        }

        categoryAdapter.setClickListener {
            viewmodel.getFoodsByCategory(it)
        }

        binding.apply {
            recyclerFoods.layoutManager = LinearLayoutManager(requireContext())
            recyclerFoods.adapter = foodsAdapter

            recyclerCategory.layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            recyclerCategory.adapter = categoryAdapter


            val credential = EmailAuthProvider.getCredential(user.email.toString(), "123456")

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
            }
        }
    }
}