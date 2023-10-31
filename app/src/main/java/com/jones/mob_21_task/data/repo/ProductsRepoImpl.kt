package com.jones.mob_21_task.data.repo

import com.jones.mob_21_task.data.apis.ProductsApi
import com.jones.mob_21_task.data.model.Product

class ProductsRepoImpl(
    private val api: ProductsApi
) : ProductsRepo {
    override suspend fun getAllProducts(): List<Product> {
        return api.getAllProducts().products
    }
}