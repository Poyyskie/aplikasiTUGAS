package com.example.core.data.source.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.core.model.Laptop
import com.example.core.model.User

@Database(entities = [User::class, Laptop::class],version = 1,exportSchema = false)
abstract class Database: RoomDatabase() {
abstract fun dao(): Dao
}