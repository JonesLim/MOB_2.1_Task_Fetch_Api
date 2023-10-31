package com.jones.mob_21_task.data.repo

import com.jones.mob_21_task.data.model.Product

interface ProductsRepo {
    suspend fun getAllProducts(): List<Product>
}