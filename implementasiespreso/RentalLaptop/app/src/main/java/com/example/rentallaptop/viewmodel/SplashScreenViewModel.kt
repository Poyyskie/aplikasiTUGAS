package com.example.rentallaptop.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.data.source.local.LocalDataSource
import kotlinx.coroutines.launch

class SplashScreenViewModel(private val localDataSource: LocalDataSource): ViewModel() {

    private val _isLoggined = MutableLiveData<Boolean>()
    val isLoggined: LiveData<Boolean> = _isLoggined

    fun isLogginedUser() {
        viewModelScope.launch {
            _isLoggined.postValue(localDataSource.isLoginnedUser())
        }
    }
}