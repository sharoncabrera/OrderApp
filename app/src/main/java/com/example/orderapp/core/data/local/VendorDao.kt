package com.example.orderapp.core.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Transaction
import androidx.room.Query
import com.example.orderapp.core.data.local.entities.Vendor
import com.example.orderapp.core.data.local.entities.VendorWithProductsDataObject

@Dao
interface VendorDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertVendor(vendor: Vendor)

    @Transaction
    @Query("SELECT * FROM Vendor")
    suspend fun getVendors(): List<VendorWithProductsDataObject>

    @Query("SELECT name FROM Vendor WHERE VendorId = :vendorId")
    suspend fun getVendorNameById(vendorId: String): String
}