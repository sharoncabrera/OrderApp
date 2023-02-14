package com.example.orderapp.core.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class Vendor (
    @PrimaryKey val vendorId: String,
    val name: String
        )