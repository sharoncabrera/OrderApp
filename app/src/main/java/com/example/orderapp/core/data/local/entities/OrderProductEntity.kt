package com.example.orderapp.core.data.local.entities

import androidx.room.Entity

//many to many
@Entity(primaryKeys = ["orderId", "productId"])
data class OrderProduct(
    val orderId: String,
    val productId: String,
    val amount: Int

)