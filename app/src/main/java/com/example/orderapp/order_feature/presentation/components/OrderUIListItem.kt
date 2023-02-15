package com.example.orderapp.order_feature.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.orderapp.order_feature.presentation.state.OrderListItem
import com.example.orderapp.ui.theme.white

@Composable
fun OrderUIListItem(
    orderListItem: OrderListItem,
    modifier: Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Text(
                text = orderListItem.vendorName,
                fontWeight = FontWeight.Bold,
                color = white,
                fontSize = 20.sp
            )

            Text(
                text = "%.2f".format(orderListItem.totalAmount) + " €",
                fontWeight = FontWeight.Bold,
                color = white,
                fontSize = 20.sp
            )
            Divider(color = white)
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center,
            ) {
                Text(
                    text = orderListItem.orderDate,
                    color = white,
                    fontSize = 16.sp
                )
            }
        }
    }
}