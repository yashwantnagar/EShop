package com.ynr.eshop.repository

import com.ynr.eshop.api.RetrofitClient

class HomeRepository (private val retrofitClient : RetrofitClient) {

    suspend fun getAllProduct() = retrofitClient.getAllProducts()

}