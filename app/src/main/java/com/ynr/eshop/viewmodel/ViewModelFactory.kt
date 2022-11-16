package com.ynr.eshop.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ynr.eshop.repository.HomeRepository

class ViewModelFactory (private val homeRepository: HomeRepository)
    : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        return if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            HomeViewModel(this.homeRepository) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }

    }

}