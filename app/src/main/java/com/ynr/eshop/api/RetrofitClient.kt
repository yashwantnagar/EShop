package com.ynr.eshop.api

import com.ynr.eshop.model.AllProduct
import com.ynr.eshop.util.AppResources
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface RetrofitClient {

    @GET(AppResources.ALL_PRODUCT)
    fun getAllProducts() : Call<List<AllProduct>>

    companion object {

        var retrofitClient : RetrofitClient? = null

          fun getInstance() : RetrofitClient {

            if (retrofitClient == null) {

                val retrofit = Retrofit.Builder()
                    .baseUrl(AppResources.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

                retrofitClient = retrofit.create(RetrofitClient::class.java)

            }

            return retrofitClient!!

        }

    }

}
