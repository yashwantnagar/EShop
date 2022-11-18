package com.ynr.eshop.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.ynr.eshop.R

class ProductDetailActivity : AppCompatActivity() {

    val TAG = "ProductDetailActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_detail)

//        val id = intent.getStringExtra("id").toString()
//        val price = intent.getStringExtra("price").toString()
        val title = intent.getStringExtra("title").toString()
        val image = intent.getStringExtra("image").toString()
        val category = intent.getStringExtra("category").toString()
        val description = intent.getStringExtra("description").toString()
//        val rate = intent.getStringExtra("rate").toString()
//        val count = intent.getStringExtra("count").toString()

        Log.e(TAG, "ProductDetailActivity: $title -- $category " )

    }

}