package com.example.orderapp.core.data.local.entities

import androidx.room.Embedded
import androidx.room.Relation


data class VendorWithProductsDataObject(
    @Embedded val vendorEntity: Vendor,
    @Relation(
        parentColumn = "vendorId",
        entityColumn = "belongsToVendor"
    )
    val product: List<Product>
)
