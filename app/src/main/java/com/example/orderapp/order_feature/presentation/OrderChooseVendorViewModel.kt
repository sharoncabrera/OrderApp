package com.example.orderapp.order_feature.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.orderapp.core.domain.model.Vendor
import com.example.orderapp.order_feature.presentation.domain.repository.OrderRepository
import com.example.orderapp.order_feature.presentation.domain.use_case.FilterListByNameUseCase
import com.example.orderapp.order_feature.presentation.domain.use_case.SortedListByNameUseCase
import com.example.orderapp.order_feature.presentation.mapper.toVendorListItem
import com.example.orderapp.order_feature.presentation.state.VendorListItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OrderChooseVendorViewModel @Inject constructor(
    private val orderRepository: OrderRepository,
    private val sortedListByNameUseCase: SortedListByNameUseCase,
    private val filterListByNameUseCase: FilterListByNameUseCase
) : ViewModel() {

    private lateinit var vendors: List<Vendor>

    var vendorsToShow by mutableStateOf<List<VendorListItem>>(emptyList())
        private set

    var vendorsSearchQuery by mutableStateOf("")
        private set


    init {

        viewModelScope.launch {
            vendors = orderRepository.getVendors()
            setupVendorsToShow()
        }
    }

    fun onSearchQueryChange(newValue: String) {
        vendorsSearchQuery = newValue
        setupVendorsToShow()
    }

    private fun setupVendorsToShow() {

        vendorsToShow = filterListByNameUseCase(
            sortedListByNameUseCase(vendors), vendorsSearchQuery
        ).map { vendor ->
            vendor.toVendorListItem()
        }

    }
}