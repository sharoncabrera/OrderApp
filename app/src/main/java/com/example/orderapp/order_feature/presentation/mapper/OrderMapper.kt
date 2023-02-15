package com.example.orderapp.order_feature.presentation.mapper

import com.example.orderapp.order_feature.presentation.domain.model.Order
import com.example.orderapp.order_feature.presentation.state.OrderDetailListItem
import com.example.orderapp.order_feature.presentation.state.OrderListItem

fun Order.toOrderDetailListItem(): OrderDetailListItem {

    return OrderDetailListItem(
        orderId = orderId,
        vendorName = vendorName,
        orderDate = date,
        products = products.map { boughtProduct ->
            boughtProduct.toProductListItem()
        }
    )
}

fun Order.toOrderListItem(): OrderListItem {
    return OrderListItem(
        orderId = orderId,
        vendorName = vendorName,
        orderDate = date,
        totalAmount = products.sumOf {
            (it.amount * it.pricePerAmount).toDouble()
        }

    )
}