package uz.gita.fooddeliveryapp_bek.presentation.ui.screens.signin

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import uz.gita.fooddeliveryapp_bek.R
import uz.gita.fooddeliveryapp_bek.databinding.SigninScreenBinding
import uz.gita.fooddeliveryapp_bek.utils.toast

@AndroidEntryPoint
class SignInScreen : Fragment(R.layout.signin_screen) {

    private val binding by viewBinding(SigninScreenBinding::bind)
    private val viewModel by viewModels<SignInViewModelImpl>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.errorData.observe(viewLifecycleOwner) {
            requireContext().toast("Sign in error = $it")
        }

        binding.apply {

            btnSave.setOnClickListener {
                val email = edtEmail.text.toString().trim()
                val password = edtPassword.text.toString().trim()

                if (email.isNotEmpty() && password.isNotEmpty()) {
                    viewModel.signIn(email, password)
                    findNavController().popBackStack()
                    findNavController().navigate(R.id.homeScreen)

                } else {
                    requireContext().toast("Fill the form")
                }
            }

            btnSignUp.setOnClickListener {
                findNavController().popBackStack()
                findNavController().navigate(R.id.signUpScreen)
            }
        }
    }
}