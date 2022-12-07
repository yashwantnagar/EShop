package com.ynr.eshop.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ynr.eshop.model.AllProduct
import com.ynr.eshop.repository.HomeRepository
import kotlinx.coroutines.*

class HomeViewModel(private val homeRepository : HomeRepository) : ViewModel() {

    private val _errorMessage = MutableLiveData<String>()
    val errorMessage get() = _errorMessage

    private val _loading = MutableLiveData<Boolean>()
    val loading get() = _loading

    private val _productLiveData = MutableLiveData<List<AllProduct>>()
    val productLiveData get() = _productLiveData

    private var job : Job? = null

    init {
        getAllProduct()
    }


    private fun getAllProduct() {

        job = CoroutineScope(Dispatchers.IO).launch {

            val response = homeRepository.getAllProduct()

            withContext(Dispatchers.Main) {

                if (response.isSuccessful) {

                    productLiveData.postValue(response.body())
                    loading.value = false

                } else {

                    onError("Error : ${response.message()} ")

                }

            }

        }

    }

    private fun onError(message: String) {
        errorMessage.value = message
        loading.value = false
    }

    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }

}
