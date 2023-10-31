package com.jones.mob_21_task.ui.home

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.jones.mob_21_task.data.model.Product
import com.jones.mob_21_task.data.repo.ProductsRepo
import com.jones.mob_21_task.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repo: ProductsRepo
) : BaseViewModel() {

    private val _products: MutableStateFlow<List<Product>> = MutableStateFlow(listOf())
    val products: StateFlow<List<Product>> = _products


    init {
        getAllProducts()
    }

    private fun getAllProducts() {
        viewModelScope.launch {
            safeApiCall {
                repo.getAllProducts()
            }?.let {
                Log.d("debugging", it.toString())
                _products.value = it
            }
        }
    }


    fun refresh() {
        getAllProducts()
    }
}