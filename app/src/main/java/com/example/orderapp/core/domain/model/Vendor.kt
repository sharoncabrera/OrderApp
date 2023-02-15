package com.example.orderapp.core.domain.model

import com.example.orderapp.core.domain.SelectAndSortableByName

data class Vendor(
    val vendorId:String,
    override val name:String,
    val products: List<Product>
): SelectAndSortableByName
