package com.ynr.eshop.repository

import com.ynr.eshop.api.RetrofitClient

class HomeRepository (private val retrofitClient : RetrofitClient ) {

    suspend fun getAllProduct() = retrofitClient.getAllProduct()


}


/*
class HomeRepository(private val apiInterface: ApiInterface, applicationContext : Application) {

//    suspend fun getAllProduct() = retrofitClient.getAllProducts()


    private val allProductLiveData = MutableLiveData<List<AllProduct>>()

    val allProduct: LiveData<List<AllProduct>>
        get() = allProductLiveData


    suspend fun getAllProducts(applicationContext : Application){

        val result = apiInterface.getAllProducts()
        if(result.body() != null){
//                quoteDatabase.quoteDao().addQuotes(result.body()!!.results)
            allProductLiveData.postValue(result.body())
        }
    }
}*/
