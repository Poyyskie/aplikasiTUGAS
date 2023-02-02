package com.example.rentallaptop.main_ui.browse

import androidx.lifecycle.ViewModel
import com.example.rentallaptop.Product
import com.example.rentallaptop.ProductDummy

class BrowseViewModel : ViewModel() {

    fun getAllProducts(): List<Product> = ProductDummy.getAllProducts()
}