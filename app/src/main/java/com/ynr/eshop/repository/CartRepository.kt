package com.ynr.eshop.repository

import androidx.lifecycle.LiveData
import com.ynr.eshop.database.Product
import com.ynr.eshop.database.ProductDao
import com.ynr.eshop.database.ProductDatabase

class CartRepository(private val database : ProductDatabase) {

    fun getAllProduct() : LiveData<List<Product>> = database.getProductDao().getAllProducts()

    suspend fun insertProduct(product: Product){
        database.getProductDao().insertProduct(product)
    }

    suspend fun deleteProduct(product: Product){
        database.getProductDao().deleteProduct(product)
    }

    suspend fun updateProduct(product: Product){
        database.getProductDao().updateProduct(product)
    }

    suspend fun clearProduct(){
        database.getProductDao().clearProduct()
    }

}

/*
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

}*/
