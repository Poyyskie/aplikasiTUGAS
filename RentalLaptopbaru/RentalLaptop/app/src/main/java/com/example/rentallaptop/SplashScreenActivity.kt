package com.example.rentallaptop

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import com.example.rentallaptop.viewmodel.SplashScreenViewModel
import org.koin.android.ext.android.inject

class SplashScreenActivity : AppCompatActivity() {

    private val viewModel: SplashScreenViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        viewModel.isLoggined.observe(this, { isLoggined ->
            var intent = Intent(this, SignInActivity::class.java)
            if (isLoggined) {
                intent = Intent(this, DashboardActivity::class.java)
            }

            startActivity(intent)
        })

        Handler(Looper.getMainLooper()).postDelayed(
            {
                viewModel.isLogginedUser()
            }, 2000
        )
    }
}