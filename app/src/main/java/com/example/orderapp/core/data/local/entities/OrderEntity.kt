package com.example.orderapp.core.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Order(
    @PrimaryKey val orderId: String,
    val date: String,
    val delivererTime: String,
    val vendorName: String
)
