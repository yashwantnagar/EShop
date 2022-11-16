package com.ynr.eshop.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ynr.eshop.model.AllProduct
import com.ynr.eshop.repository.HomeRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeViewModel(private val homeRepository: HomeRepository) : ViewModel() {

    val allProductList = MutableLiveData<List<AllProduct>>()
    val errorMessage = MutableLiveData<String>()

    val loadingProgressBar = MutableLiveData<Boolean>()

    private val TAG = "HomeViewModel"

    init {
        getAllProduct()
    }

    private fun getAllProduct() {

        viewModelScope.launch(Dispatchers.IO) {

            try {

                val response = homeRepository.getAllProduct()
                response.enqueue(object : Callback<List<AllProduct>> {

                    override fun onResponse(call: Call<List<AllProduct>>,
                                            response: Response<List<AllProduct>>) {

                        allProductList.postValue(response.body())

                        loadingProgressBar.value = false

//                        Log.e(TAG, "onResponse: ${response.body()}" )

                    }

                    override fun onFailure(call: Call<List<AllProduct>>, t: Throwable) {

                        errorMessage.postValue(t.message)

                        loadingProgressBar.value = false

//                        Log.e(TAG, "onFailure: ${t.message}" )

                    }

                })

            } catch (e : Exception){

                Log.e(TAG, "Exception: ${e.message}" )

            }


        }

    }

}