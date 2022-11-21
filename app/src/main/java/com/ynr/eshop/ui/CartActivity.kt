package com.ynr.eshop.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ynr.eshop.R
import com.ynr.eshop.adapter.CartAdapter

class CartActivity : AppCompatActivity() {

    lateinit var cartRV : RecyclerView
    lateinit var cartAdapter : CartAdapter
    lateinit var backBtn : AppCompatImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

        cartRV = findViewById(R.id.cartRV)
        backBtn = findViewById(R.id.backBtn)

        cartRV.setHasFixedSize(true)
        cartRV.layoutManager = LinearLayoutManager(this)


        backBtn.setOnClickListener { onBackPressedDispatcher.onBackPressed() }

        cartAdapter = CartAdapter()
        cartRV.adapter = cartAdapter

    }
}