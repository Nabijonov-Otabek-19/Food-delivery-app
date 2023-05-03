package uz.gita.fooddeliveryapp_bek.presentation.ui.screens

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import uz.gita.fooddeliveryapp_bek.R
import uz.gita.fooddeliveryapp_bek.databinding.SignupScreenBinding

class SignUpScreen : Fragment(R.layout.signup_screen) {

    private val binding by viewBinding(SignupScreenBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val auth = Firebase.auth

        binding.apply {

            btnSave.setOnClickListener {

                auth.createUserWithEmailAndPassword(
                    edtEmail.text.toString().trim(),
                    edtPassword.text.toString().trim()

                ).addOnSuccessListener {
                    Toast.makeText(requireContext(), it.user.toString(), Toast.LENGTH_SHORT).show()
                    findNavController().popBackStack()
                    findNavController().navigate(R.id.homeScreen)

                }.addOnFailureListener {
                    Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()
                }
            }

            btnSignIn.setOnClickListener {
                findNavController().popBackStack()
                findNavController().navigate(R.id.signInScreen)
            }
        }
    }
}