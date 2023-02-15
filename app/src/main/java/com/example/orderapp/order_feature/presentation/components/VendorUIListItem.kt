package com.example.orderapp.order_feature.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForwardIos
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.orderapp.order_feature.presentation.state.VendorListItem
import com.example.orderapp.ui.theme.white

@Composable
fun VendorUIListItem(
    vendorListItem: VendorListItem,
    modifier: Modifier
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Text(
            text = vendorListItem.name,
            color = white
        )
        Icon(
            imageVector = Icons.Default.ArrowForwardIos, contentDescription = "arrow_right",
            tint = white
        )
    }
}