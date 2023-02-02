package com.example.rentallaptop.main_ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.core.model.Laptop
import com.example.rentallaptop.Product
import com.example.rentallaptop.adapter.SliderAdapter
import com.example.rentallaptop.databinding.ActivityDetailLaptopBinding
import com.smarteist.autoimageslider.SliderView
import org.koin.android.ext.android.inject

class DetailLaptopActivity : AppCompatActivity() {
    private val viewModel: DetailLaptopViewModel by inject()
    private lateinit var binding: ActivityDetailLaptopBinding
    private lateinit var product: Product

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailLaptopBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.cart.observe(this, {
            Toast.makeText(this, "${product.name} berhasil menambahkan ke keranjang", Toast.LENGTH_SHORT).show()
        })

        intent.getParcelableExtra<Product>(GET_PRODUCT).let { product ->
            if (product == null) finish()
            else this.product = product
        }

        with(binding){
            tvName.text = product.name
            tvSpec.text = product.specification
            tvPrice.text = "Rp.${product.price}"

            cart.setOnClickListener {
                viewModel.addToCart(Laptop(idLaptop = product.id))
            }

            imageSlider.apply {
                setImageInSlider(arrayListOf(product.imgPath), this)
            }
        }
    }
    private fun setImageInSlider(images: ArrayList<Int>, imageSlider: SliderView) {
        val adapter = SliderAdapter(this)
        adapter.renewItems(images)
        imageSlider.setSliderAdapter(adapter)
        imageSlider.isAutoCycle = true
        imageSlider.startAutoCycle()
    }


    companion object {
        const val GET_PRODUCT = "GET_PRODUCT"
    }
}