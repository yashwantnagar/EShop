package com.ynr.eshop.api

import com.ynr.eshop.model.AllProduct
import com.ynr.eshop.util.AppResources
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {

    @GET(AppResources.ALL_PRODUCT)
    fun getAllProducts() : Call<List<AllProduct>>

}