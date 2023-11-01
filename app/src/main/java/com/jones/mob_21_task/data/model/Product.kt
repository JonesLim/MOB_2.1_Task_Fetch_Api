package com.jones.mob_21_task.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Product(
    val category: String,
    val description: String,
    val id: Int,
    val images: List<String>,
    val price: Int,
    val title: String
)