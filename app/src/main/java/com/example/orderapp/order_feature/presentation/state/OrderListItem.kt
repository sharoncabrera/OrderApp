package com.example.orderapp.order_feature.presentation.state

data class OrderListItem(
    val orderId: String,
    val vendorName: String,
    val totalAmount: Double,
    val orderDate: String
)