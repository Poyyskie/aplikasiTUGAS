package com.example.rentallaptop.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.data.source.local.LocalDataSource
import com.example.core.model.User
import kotlinx.coroutines.launch

class SignUpViewModel (private val localDataSource: LocalDataSource): ViewModel() {
    private val _register = MutableLiveData<Boolean>()
    val register: LiveData<Boolean> = _register

    fun signUp(user: User) {
        viewModelScope.launch {
            _register.postValue(localDataSource.addUser(user))
        }
    }
}