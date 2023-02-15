package com.example.orderapp.core.presentation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.orderapp.order_feature.presentation.OrderChooseVendorScreen
import com.example.orderapp.order_feature.presentation.OrderScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = ScreenRoute.OrderScreen.route
    ) {

        composable(ScreenRoute.OrderScreen.route){
            OrderScreen(navController = navController)
        }

        composable(ScreenRoute.OrderChooseVendorScreen.route){
            OrderChooseVendorScreen(navController = navController)
        }
    }
}

sealed class ScreenRoute(val route: String) {

    object OrderScreen : ScreenRoute("order_screen")
    object OrderChooseVendorScreen : ScreenRoute("order_choose_vendor_screen")
    object OrderChooseProductsScreen : ScreenRoute("order_choose_products_screen")
}