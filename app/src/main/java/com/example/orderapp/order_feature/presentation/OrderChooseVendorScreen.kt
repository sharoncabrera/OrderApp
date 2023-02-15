package com.example.orderapp.order_feature.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.orderapp.core.presentation.ScreenRoute
import com.example.orderapp.order_feature.presentation.components.VendorUIListItem
import com.example.orderapp.ui.theme.gray
import com.example.orderapp.ui.theme.orange
import com.example.orderapp.ui.theme.white

@Composable
fun OrderChooseVendorScreen(
    navController: NavController,
    orderChooseVendorViewModel: OrderChooseVendorViewModel = hiltViewModel()
) {


    val scaffoldState = rememberScaffoldState()

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "Deliverer selection",
                        color = white
                    )
                },
                backgroundColor = orange
            )
        }
    ) {
        print(it)
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(gray)
                .padding(15.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TextField(
                value = orderChooseVendorViewModel.vendorsSearchQuery,
                onValueChange = {
                    orderChooseVendorViewModel.onSearchQueryChange(it)
                },
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = white,
                    textColor = gray,
                    cursorColor = orange,
                    focusedLabelColor = orange,
                    focusedIndicatorColor = orange
                ),
                label = {
                    Text("Search deliverer")
                },
                maxLines = 1
            )
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(10.dp),
                modifier = Modifier
                    .padding(top = 20.dp)
            ) {
                items(
                    orderChooseVendorViewModel.vendorsToShow,
                    key = { delivererListItem ->
                        delivererListItem.vendorId
                    }
                ) {
                    VendorUIListItem(
                        it,
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(10.dp))
                            .border(1.dp, color = white, RoundedCornerShape(10.dp))
                            .clickable {
                                navController.navigate(ScreenRoute.OrderChooseProductsScreen.route + "/${it.vendorId}")
                            }
                            .padding(15.dp)

                    )
                }
            }
        }

    }

}
