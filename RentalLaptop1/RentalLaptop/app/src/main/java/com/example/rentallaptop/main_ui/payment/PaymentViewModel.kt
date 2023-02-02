package com.example.rentallaptop.main_ui.payment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.data.source.local.LocalDataSource
import com.example.core.model.Laptop
import kotlinx.coroutines.launch

class PaymentViewModel(private val localDataSource: LocalDataSource) : ViewModel() {
    private val _products = MutableLiveData<List<Laptop>>()
    val products: LiveData<List<Laptop>> = _products

    fun getAllProducts() {
        viewModelScope.launch {
            _products.postValue(localDataSource.getLaptops())
        }
    }
}