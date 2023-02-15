package com.example.orderapp.order_feature.presentation.domain.model

data class BoughtProduct(
    val productId: String,
    val name: String,
    val pricePerAmount: Float,
    val amount: Int
)
