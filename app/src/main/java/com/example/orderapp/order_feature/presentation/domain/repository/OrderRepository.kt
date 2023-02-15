package com.example.orderapp.order_feature.presentation.domain.repository

import com.example.orderapp.core.domain.model.Product
import com.example.orderapp.core.domain.model.Vendor
import com.example.orderapp.order_feature.presentation.domain.model.Order

interface OrderRepository {

    suspend fun insertOrder(order: Order)
    suspend fun getOrders(): List<Order>
    suspend fun getVendors(): List<Vendor>
    suspend fun getProductsForVendor(vendorId: String): List<Product>
    suspend fun getVendorNameById(vendorId: String): String

}
