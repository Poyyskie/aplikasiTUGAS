package com.example.rentallaptop.main_ui.account

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.data.source.local.LocalDataSource
import com.example.core.model.User
import kotlinx.coroutines.launch

class AccountViewModel(private val localDataSource: LocalDataSource): ViewModel() {
    private val _logout = MutableLiveData<Boolean>()
    val logout: LiveData<Boolean> = _logout

    private val _user = MutableLiveData<User>()
    val user: LiveData<User> = _user

    fun logout() {
        viewModelScope.launch {
            _logout.postValue(localDataSource.signOut())
        }
    }

    fun getDataUser(){
        viewModelScope.launch {
            localDataSource.getUser()?.let { user ->
                _user.postValue(user)
            }
        }
    }
}