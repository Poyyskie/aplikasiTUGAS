package com.example.core.data.source.local.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.core.model.Laptop
import com.example.core.model.User

@Dao
interface Dao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addUser(user: User)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addLaptop(laptop: Laptop)

    @Query("SELECT * FROM user WHERE id =:userId")
    suspend fun getUser(userId: String): User

    @Query("SELECT * FROM laptop")
    suspend fun getLaptops(): List<Laptop>

    @Query("SELECT * FROM user WHERE username =:username AND password =:password")
    suspend fun loginUser(username: String, password: String): User
}