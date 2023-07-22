package uz.gita.fooddeliveryapp_bek.presentation.ui.screens.signup

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import uz.gita.fooddeliveryapp_bek.R
import uz.gita.fooddeliveryapp_bek.databinding.ScreenSignupBinding
import uz.gita.fooddeliveryapp_bek.utils.logger
import uz.gita.fooddeliveryapp_bek.utils.toast

@AndroidEntryPoint
class SignUpScreen : Fragment(R.layout.screen_signup) {

    private val binding by viewBinding(ScreenSignupBinding::bind)
    private val viewModel by viewModels<SignUpViewModelImpl>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.errorData.observe(viewLifecycleOwner) {
            toast(it)
            logger("Sign Up error = $it")
        }

        viewModel.successData.observe(viewLifecycleOwner) {
            findNavController().popBackStack()
            findNavController().navigate(R.id.homeScreen)
        }

        binding.apply {

            btnSave.setOnClickListener {
                val email = edtEmail.text.toString().trim()
                val password = edtPassword.text.toString().trim()
                if (email.isNotEmpty() && password.isNotEmpty()) {
                    viewModel.signUp(email, password)
                } else {
                   toast("Fill the form")
                }
            }

            btnSignIn.setOnClickListener {
                findNavController().popBackStack()
                findNavController().navigate(R.id.signInScreen)
            }
        }
    }
}