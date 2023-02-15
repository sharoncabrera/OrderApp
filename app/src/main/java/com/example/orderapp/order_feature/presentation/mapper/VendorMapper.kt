package com.example.orderapp.order_feature.presentation.mapper

import com.example.orderapp.core.domain.model.Vendor
import com.example.orderapp.order_feature.presentation.state.VendorListItem

fun Vendor.toVendorListItem(): VendorListItem {
    return VendorListItem(
        vendorId = vendorId,
        name = name
    )
}