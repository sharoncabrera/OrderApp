package com.example.orderapp.order_feature.presentation.domain.model

data class Order(
    val orderId:String,
    val date: String,
    val delivererTime: String,
    val vendorName: String,
    val products: List<BoughtProduct>
)
