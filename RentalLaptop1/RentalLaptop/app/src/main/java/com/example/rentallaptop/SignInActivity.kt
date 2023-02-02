package com.example.rentallaptop

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.rentallaptop.databinding.ActivitySignInBinding
import com.example.rentallaptop.viewmodel.SignInViewModel
import org.koin.android.ext.android.inject

class SignInActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignInBinding
    private val viewModel: SignInViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)


        viewModel.login.observe(this, { isSuccess ->
            if (isSuccess) {
                startActivity(Intent(this, DashboardActivity::class.java))
            }else {
                Toast.makeText(this, "Pastikan anda memasukkan username dan password yang benar", Toast.LENGTH_SHORT).show()
            }
        })

        setupListener()
    }

    private fun setupListener() {
        with(binding){
            signIn.setOnClickListener {
            val username = etUsername.text.toString()
            val password = etPassword.text.toString()
                viewModel.login(username, password)
            }

            signUp.setOnClickListener {
                startActivity(Intent(this@SignInActivity, SignUpActivity::class.java))
            }
        }
    }
}