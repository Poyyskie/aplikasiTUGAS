package com.example.rentallaptop.main_ui.payment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.rentallaptop.ProductDummy
import com.example.rentallaptop.R
import com.example.rentallaptop.databinding.ActivityPaymentBinding
import org.koin.android.ext.android.inject

class PaymentActivity : AppCompatActivity() {

    private val viewModel: PaymentViewModel by inject()
    private lateinit var binding: ActivityPaymentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPaymentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.products.observe(this,{ products ->
            var price = 0
            products.forEach {
                ProductDummy.getAllProducts().find { product -> product.id.equals(it.idLaptop, true) }?.let { product ->
                    price += product.price
                }
            }
            binding.tvTotal.text = "Rp.$price"
        })

        viewModel.getAllProducts()
    }
}