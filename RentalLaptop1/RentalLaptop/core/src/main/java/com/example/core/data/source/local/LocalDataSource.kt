package com.example.core.data.source.local

import android.util.Log
import com.example.core.data.source.local.room.Dao
import com.example.core.data.source.preferences.UserPreferences
import com.example.core.model.Laptop
import com.example.core.model.User
import kotlinx.coroutines.flow.first

class LocalDataSource(private val dao: Dao, private val preferences: UserPreferences) {
    suspend fun addUser(user: User): Boolean =
        try {
            dao.addUser(user)
            true
        } catch (e: Exception) {
            Log.e(javaClass.name, e.message.toString())
            false
        }
    suspend fun addLaptop(laptop: Laptop): Boolean =
        try {
            dao.addLaptop(laptop)
            true
        } catch (e: Exception) {
            Log.e(javaClass.name, e.message.toString())
            false
        }

    suspend fun getLaptops(): List<Laptop> =
        try {
            dao.getLaptops()
        } catch (e: Exception) {
            Log.e(javaClass.name, e.message.toString())
            emptyList()
        }

    suspend fun loginUser(username: String, password: String): Boolean =
        try {
            dao.loginUser(username, password).let {
                preferences.saveUserId(it.id)
                return true
            }
        } catch (e: Exception) {
            Log.e(javaClass.name, e.message.toString())
            false
        }

    suspend fun isLoginnedUser(): Boolean =
        try {
            preferences.getUserId().first()?.let {
                return it.isNotEmpty()
            }
            false
        } catch (e: Exception) {
            Log.e(javaClass.name, e.message.toString())
            false
        }

    suspend fun getUser(): User? = preferences.getUserId().first().let { userId ->
        if (userId != null) dao.getUser(userId)
        else null
    }

    suspend fun signOut(): Boolean =
        try {
            preferences.clearCache()
            preferences.getUserId().first().let {
                return it.isNullOrEmpty()
            }
        } catch (e: Exception) {
            Log.e(javaClass.name, e.message.toString())
            false
        }
}