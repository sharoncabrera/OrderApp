package com.example.orderapp.order_feature.presentation.state

import com.example.orderapp.core.domain.model.Product

data class OrderDetailListItem(
    val orderId: String,
    val vendorName: String,
    val orderDate: String,
    val products: List<ProductListItem>
)