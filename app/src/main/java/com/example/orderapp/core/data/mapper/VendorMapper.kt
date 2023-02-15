package com.example.orderapp.core.data.mapper

import com.example.orderapp.core.data.local.entities.VendorEntity
import com.example.orderapp.core.domain.model.Product
import com.example.orderapp.core.domain.model.Vendor

fun VendorEntity.toVendor(products: List<Product>): Vendor {
    return Vendor(
        vendorId = vendorId,
        name = name,
        products = products

    )
}