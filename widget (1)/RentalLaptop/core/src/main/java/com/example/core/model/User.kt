package com.example.core.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    @PrimaryKey
    val id: String,
    val username: String,
    val password: String,
    val email: String,
    val name: String,
    val phoneNumber: String,
    val saldo: Int = 0
)
