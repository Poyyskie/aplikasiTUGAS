package com.example.rentallaptop.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.data.source.local.LocalDataSource
import kotlinx.coroutines.launch

class SignInViewModel(private val localDataSource: LocalDataSource):ViewModel() {
    private val _login = MutableLiveData<Boolean>()
    val login: LiveData<Boolean> = _login

    fun login(username: String, password: String) {
        viewModelScope.launch {
            _login.postValue(localDataSource.loginUser(username, password))
        }
    }
}