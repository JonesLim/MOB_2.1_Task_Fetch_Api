package com.jones.mob_21_task.di

import com.jones.mob_21_task.data.apis.ProductsApi
import com.jones.mob_21_task.data.repo.ProductsRepo
import com.jones.mob_21_task.data.repo.ProductsRepoImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepoModule {

    @Provides
    @Singleton
    fun provideProductsRepo(productsApi: ProductsApi): ProductsRepo {
        return ProductsRepoImpl(productsApi)
    }
}