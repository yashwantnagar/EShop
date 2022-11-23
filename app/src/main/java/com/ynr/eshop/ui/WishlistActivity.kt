package com.ynr.eshop.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ynr.eshop.R
import com.ynr.eshop.adapter.WishlistAdapter

class WishlistActivity : AppCompatActivity() {

    lateinit var wishlistRV : RecyclerView
    lateinit var wishlistAdapter : WishlistAdapter
    lateinit var backBtn : AppCompatImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wishlist)

        wishlistRV = findViewById(R.id.wishlistRV)
        backBtn = findViewById(R.id.backBtn)

        wishlistRV.setHasFixedSize(true)
        wishlistRV.layoutManager = LinearLayoutManager(this)


        backBtn.setOnClickListener { onBackPressedDispatcher.onBackPressed() }

        wishlistAdapter = WishlistAdapter()
        wishlistRV.adapter = wishlistAdapter

    }

}