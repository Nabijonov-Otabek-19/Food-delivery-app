package uz.gita.fooddeliveryapp_bek.presentation.ui.screens

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import uz.gita.fooddeliveryapp_bek.R
import uz.gita.fooddeliveryapp_bek.databinding.HomeScreenBinding
import uz.gita.fooddeliveryapp_bek.presentation.ui.adapters.HomeAdapter

class HomeScreen : Fragment(R.layout.home_screen) {

    private val binding by viewBinding(HomeScreenBinding::bind)
    private val adapter by lazy { HomeAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val user = FirebaseAuth.getInstance().currentUser!!

        binding.apply {
            recycler.layoutManager = LinearLayoutManager(requireContext())
            recycler.adapter = adapter


            btnLogout.setOnClickListener {
                user.delete().addOnCompleteListener {
                    Toast.makeText(requireContext(), "User deleted", Toast.LENGTH_SHORT).show()
                    findNavController().popBackStack()
                    findNavController().navigate(R.id.signUpScreen)
                }
            }
        }
    }
}