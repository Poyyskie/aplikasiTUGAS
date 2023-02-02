package com.example.rentallaptop.main_ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.data.source.local.LocalDataSource
import com.example.core.model.Laptop
import kotlinx.coroutines.launch

class DetailLaptopViewModel(private val localDataSource: LocalDataSource): ViewModel() {
    private val _cart = MutableLiveData<Boolean>()
    val cart: LiveData<Boolean> = _cart

    fun addToCart(laptop: Laptop) {
        viewModelScope.launch {
            _cart.postValue(localDataSource.addLaptop(laptop))
        }
    }
}