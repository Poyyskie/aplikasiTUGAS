package com.example.core.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Laptop(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val idLaptop: String
)
