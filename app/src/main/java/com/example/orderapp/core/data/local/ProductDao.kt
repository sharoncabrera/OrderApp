package com.example.orderapp.core.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.orderapp.core.data.local.entities.Product

@Dao
interface ProductDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProduct(product: Product)

    @Query("SELECT * FROM Product WHERE belongsToVendor = : vendorId")
    suspend fun getProductsForVendor(vendorId: String): List<Product>
}