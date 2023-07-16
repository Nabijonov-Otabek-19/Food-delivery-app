package uz.gita.fooddeliveryapp_bek.presentation.ui.screens.splash

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import uz.gita.fooddeliveryapp_bek.R

@SuppressLint("CustomSplashScreen")
class SplashScreen : Fragment(R.layout.splash_screen) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val user = Firebase.auth.currentUser

        Handler(Looper.getMainLooper()).postDelayed({
            if (user == null) {
                findNavController().popBackStack()
                findNavController().navigate(R.id.signUpScreen)
            } else {
                findNavController().popBackStack()
                findNavController().navigate(R.id.homeScreen)
            }
        }, 1500)
    }
}