package com.example.orderapp.core.data.local

import androidx.room.*
import com.example.orderapp.core.data.local.entities.Order
import com.example.orderapp.core.data.local.entities.OrderProduct
import com.example.orderapp.core.data.local.entities.OrderWithProductsDataObject

@Dao
interface OrderDao {

    @Transaction
    @Query("SELECT * FROM Order")
    suspend fun getOrderWithProducts(): List<OrderWithProductsDataObject>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrder(order: Order)


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrderProduct(orderProduct: List<OrderProduct>)
}

