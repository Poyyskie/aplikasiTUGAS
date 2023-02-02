package com.example.rentallaptop.main_ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.data.source.local.LocalDataSource
import com.example.core.model.User
import kotlinx.coroutines.launch

class HomeViewModel(private val localDataSource: LocalDataSource) : ViewModel() {
    private val _user = MutableLiveData<User>()
    val user: LiveData<User> = _user

    fun getDataUser(){
        viewModelScope.launch {
            localDataSource.getUser()?.let { user ->
                _user.postValue(user)
            }
        }
    }
}