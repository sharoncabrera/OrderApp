package com.example.orderapp.order_feature.presentation.data.mapper

import com.example.orderapp.core.data.local.entities.OrderWithProductsDataObject
import com.example.orderapp.order_feature.presentation.domain.model.BoughtProduct
import com.example.orderapp.order_feature.presentation.domain.model.Order

fun OrderWithProductsDataObject.toOrder(): Order {
    return Order(
        orderId = orderEntity.orderId,
        date = orderEntity.date,
        vendorName = orderEntity.vendorName,
        delivererTime = orderEntity.delivererTime,
        //TODO: Zip
        products = productEntities.zip(orderProductEntities).map { pair ->
            BoughtProduct(
                pair.first.productId,
                pair.first.name,
                pair.first.pricePerAmount,
                pair.second.amount
            )
        }

    )
}