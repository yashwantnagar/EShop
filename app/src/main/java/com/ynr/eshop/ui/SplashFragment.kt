package com.ynr.eshop.ui

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.ynr.eshop.R
import com.ynr.eshop.util.AppResources
import com.ynr.eshop.util.SharedPref


class SplashFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Handler(Looper.getMainLooper()).postDelayed({
            findNavController().navigate(R.id.splash_to_home)},
            2000)


        /*if (SharedPref.getPrefsHelper().getPref(AppResources.KEY.Email) != null) {
            startActivity(
                Intent(
                    this@SplashActivity,
                    HomeActivity::class.java
                )
            )
            finish()
        } else {
            startActivity(
                Intent(
                    this@SplashActivity,
                    LanguageSelectActivity::class.java
                )
            )
            finish()
        }*/

    }

}