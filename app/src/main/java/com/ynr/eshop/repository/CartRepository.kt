package com.ynr.eshop.repository

import androidx.lifecycle.LiveData
import com.ynr.eshop.database.Product
import com.ynr.eshop.database.ProductDao

class CartRepository(private val productDao: ProductDao) {

    val allProduct : LiveData<List<Product>> = productDao.getAllProducts()

    suspend fun insertProduct(product: Product){
        productDao.insertProduct(product)
    }

    suspend fun deleteProduct(product: Product){
        productDao.deleteProduct(product)
    }

    suspend fun updateProduct(product: Product){
        productDao.updateProduct(product)
    }

}