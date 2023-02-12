package com.example.orderapp.core.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.orderapp.core.data.local.entities.Order
import com.example.orderapp.core.data.local.entities.OrderProduct
import com.example.orderapp.core.data.local.entities.Product
import com.example.orderapp.core.data.local.entities.Vendor

@Database(
    entities = [
        Vendor::class,
        Order::class,
        OrderProduct::class,
        Product::class
    ],
    version = 1
)
abstract class OrderDatabase : RoomDatabase() {
    abstract fun orderDao(): OrderDao
    abstract fun productDao(): ProductDao
    abstract fun vendorDao(): VendorDao
}