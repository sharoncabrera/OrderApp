package com.example.orderapp.order_feature.presentation.data.respository

import com.example.orderapp.core.data.local.OrderDao
import com.example.orderapp.core.data.local.ProductDao
import com.example.orderapp.core.data.local.VendorDao
import com.example.orderapp.core.data.local.entities.OrderProductEntity
import com.example.orderapp.core.data.mapper.toProduct
import com.example.orderapp.core.data.mapper.toVendor
import com.example.orderapp.core.domain.model.Product
import com.example.orderapp.core.domain.model.Vendor
import com.example.orderapp.order_feature.presentation.data.mapper.toOrder
import com.example.orderapp.order_feature.presentation.data.mapper.toOrderEntity
import com.example.orderapp.order_feature.presentation.domain.model.Order
import com.example.orderapp.order_feature.presentation.domain.repository.OrderRepository
import javax.inject.Inject

class OrderRepositoryImpl @Inject constructor(
    private val orderDao: OrderDao,
    private val vendorDao: VendorDao,
    private val productDao: ProductDao
) : OrderRepository {
    override suspend fun insertOrder(order: Order) {
        orderDao.insertOrder(order.toOrderEntity(order.vendorName))
        val orderProductEntities = order.products.map { boughtProduct ->
            OrderProductEntity(order.orderId, boughtProduct.productId, boughtProduct.amount)
        }
        orderDao.insertOrderProductEntities(orderProductEntities)

    }

    override suspend fun getOrders(): List<Order> {
        return orderDao.getOrderWithProducts().map {
            it.toOrder()
        }
    }

    override suspend fun getVendors(): List<Vendor> {
        return vendorDao.getVendors().map {
            it.vendorEntity.toVendor(
                it.products.map { productEntity ->
                    productEntity.toProduct()
                }
            )
        }
    }

    override suspend fun getProductsForVendor(vendorId: String): List<Product> {
        return productDao.getProductsForVendor(vendorId).map { productEntity ->
            productEntity.toProduct()
        }
    }

    override suspend fun getVendorNameById(vendorId: String): String {
        return vendorDao.getVendorNameById(vendorId)
    }
}
