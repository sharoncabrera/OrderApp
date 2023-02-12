package com.example.orderapp.core.data.local.entities

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation

data class OrderWithProductsDataObject(
    @Embedded val order: Order,
    @Relation(
        parentColumn = "orderId",
        entityColumn = "productId",
        associateBy = Junction(OrderProduct::class)
    )
    val products: List<Product>,
    @Relation(
        parentColumn = "orderId",
        entityColumn = "orderId"
    )
    val orderProduct: List<OrderProduct>
)
