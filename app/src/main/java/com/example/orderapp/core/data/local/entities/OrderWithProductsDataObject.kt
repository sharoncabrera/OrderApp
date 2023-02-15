package com.example.orderapp.core.data.local.entities

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation

data class OrderWithProductsDataObject(
    @Embedded val orderEntity: OrderEntity,
    @Relation(
        parentColumn = "orderId",
        entityColumn = "productId",
        associateBy = Junction(OrderProductEntity::class)
    )
    val productEntities: List<ProductEntity>,
    @Relation(
        parentColumn = "orderId",
        entityColumn = "orderId"
    )
    val orderProductEntities: List<OrderProductEntity>
)
