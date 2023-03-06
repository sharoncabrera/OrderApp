package com.example.orderapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.graphics.toArgb
import com.example.orderapp.core.presentation.Navigation
import com.example.orderapp.ui.theme.OrderAppTheme
import com.example.orderapp.ui.theme.orange
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //TODO: *
            window.statusBarColor = orange.toArgb()
            window.navigationBarColor = orange.toArgb()
            OrderAppTheme {
                Navigation()
            }
        }
    }
}