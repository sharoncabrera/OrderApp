package com.example.orderapp.order_feature.presentation.domain.use_case

import com.example.orderapp.core.domain.SelectAndSortableByName

class SortedListByNameUseCase {
    operator fun <T> invoke(list: List<T>): List<T> where T : SelectAndSortableByName {
        return list.sortedBy { item ->
            item.name
        }
    }
}