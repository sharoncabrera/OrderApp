package com.example.orderapp.order_feature.presentation.di

import com.example.orderapp.core.data.local.OrderDao
import com.example.orderapp.core.data.local.ProductDao
import com.example.orderapp.core.data.local.VendorDao
import com.example.orderapp.order_feature.presentation.data.respository.OrderRepositoryImpl
import com.example.orderapp.order_feature.presentation.domain.repository.OrderRepository
import com.example.orderapp.order_feature.presentation.domain.use_case.ConfirmOrderUseCase
import com.example.orderapp.order_feature.presentation.domain.use_case.FilterListByNameUseCase
import com.example.orderapp.order_feature.presentation.domain.use_case.SortedListByNameUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object OrderFeatureModule {

    @Provides
    @Singleton
    fun provideOrderRepository(
        orderDao: OrderDao,
        vendorDao: VendorDao,
        productDao: ProductDao
    ): OrderRepository {
        return OrderRepositoryImpl(orderDao, vendorDao, productDao)
    }

    @Provides
    @Singleton
    fun provideFilterByNameUseCase(): FilterListByNameUseCase {
        return FilterListByNameUseCase()
    }

    @Provides
    @Singleton
    fun provideSortedByNameUseCase(): SortedListByNameUseCase {
        return SortedListByNameUseCase()
    }


    @Provides
    @Singleton
    fun provideConfirmOrderUseCase(orderRepository: OrderRepository): ConfirmOrderUseCase {
        return ConfirmOrderUseCase(orderRepository)
    }
}