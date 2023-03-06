package com.example.orderapp.order_feature.presentation.domain.use_case

import com.example.orderapp.order_feature.presentation.domain.model.BoughtProduct
import com.example.orderapp.order_feature.presentation.domain.model.Order
import com.example.orderapp.order_feature.presentation.domain.repository.OrderRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*
import javax.inject.Inject

class ConfirmOrderUseCase @Inject constructor(
    private val orderRepository: OrderRepository
) {

    operator fun invoke(products: List<BoughtProduct>, vendorId: String) {

        val coroutineScope = CoroutineScope(Dispatchers.IO)
        val formatter: DateTimeFormatter =
            DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss")
        val date = formatter.format(LocalDateTime.now())
        coroutineScope.launch {

            val vendorName = orderRepository.getVendorNameById(vendorId)
            orderRepository.insertOrder(
                order = Order(
                    orderId = UUID.randomUUID().toString(),
                    date = date,
                    delivererTime = "As fast as possible",
                    vendorName = vendorName,
                    products = products
                )
            )
        }

    }
}