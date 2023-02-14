package com.example.orderapp.core.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Product(
    @PrimaryKey val productId: String,
    val name: String,
    val pricePerAmount: Float,
    //TODO: yo lo cambiaría por VendorId
    val belongsToVendor:String
)
