package com.jones.mob_21_task.data.apis

import android.util.Log
import com.jones.mob_21_task.data.apis.KtorClient.client
import com.jones.mob_21_task.data.model.ProductResponse
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.url
import io.ktor.client.statement.bodyAsText
import io.ktor.http.ContentType
import io.ktor.http.contentType

class ProductsApi {

    suspend fun getAllProducts(): ProductResponse {
        val res = client.get {
            url("https://dummyjson.com/products")
            contentType(ContentType.Application.Json)
        }

        Log.d("debugging", res.bodyAsText())

        return res.body()
    }
}

