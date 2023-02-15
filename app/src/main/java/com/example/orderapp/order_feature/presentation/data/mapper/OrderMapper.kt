package com.example.orderapp.order_feature.presentation.data.mapper

import com.example.orderapp.core.data.local.entities.OrderEntity
import com.example.orderapp.order_feature.presentation.domain.model.Order

fun Order.toOrderEntity(vendorName: String): OrderEntity {
    return OrderEntity(
        orderId = orderId,
        date = date,
        delivererTime = delivererTime,
        vendorName = vendorName
    )
}