package com.example.rentallaptop

import android.os.Bundle
import android.text.InputFilter
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.core.model.User
import com.example.rentallaptop.databinding.ActivitySignUpBinding
import com.example.rentallaptop.viewmodel.SignUpViewModel
import org.koin.android.ext.android.inject

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding
    private val viewModel: SignUpViewModel by inject()

    val MAX_LEN = 12
    fun EditText.limitlength(maxLength: Int){
        filters = arrayOf(InputFilter.LengthFilter(maxLength))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupListener()

        viewModel.register.observe(this, { isRegistered ->
            if (isRegistered) {
                Toast.makeText(this, "Berhasil mendaftar", Toast.LENGTH_SHORT).show()
                finish()
            }
        })
    }

    private fun setupListener() {
        binding.signUp.setOnClickListener {
            if (isValidForm()) {
                if (isSamePassword()) {
                    viewModel.signUp(getForm())
                } else {
                    Toast.makeText(this, "Password anda tidak sesusai", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Maaf anda harus melengkapi form terlebih dahulu", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun getForm(): User =
        User(
            id = System.currentTimeMillis().toString(),
            username = binding.etUsername.text.toString(),
            password = binding.etPassword.text.toString(),
            email = binding.etEmail.text.toString(),
            name = binding.etName.text.toString(),
            phoneNumber = binding.etPhoneNumber.text.toString()
        )

    private fun isSamePassword(): Boolean = binding.etPassword.text.toString().equals(binding.etRePassword.text.toString())

    private fun isValidForm(): Boolean =
        binding.etUsername.text.toString().isNotEmpty() &&
        binding.etPassword.text.toString().isNotEmpty() &&
        binding.etEmail.text.toString().isNotEmpty() &&
        binding.etName.text.toString().isNotEmpty() &&
        binding.etPhoneNumber.text.toString().isNotEmpty() &&
        binding.etRePassword.text.toString().isNotEmpty()
}