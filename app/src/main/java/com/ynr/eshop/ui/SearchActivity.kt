package com.ynr.eshop.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ynr.eshop.R
import com.ynr.eshop.adapter.SearchAdapter

class SearchActivity : AppCompatActivity() {

    lateinit var searchRV : RecyclerView
    lateinit var searchView: SearchView
    lateinit var searchAdapter: SearchAdapter
    lateinit var backBtn : AppCompatImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        searchRV = findViewById(R.id.searchRV)
        searchView = findViewById(R.id.search_view)
        backBtn = findViewById(R.id.backBtn)

        searchRV.setHasFixedSize(true)
        searchRV.layoutManager = LinearLayoutManager(this)


        backBtn.setOnClickListener { onBackPressedDispatcher.onBackPressed() }

        searchAdapter = SearchAdapter()
        searchRV.adapter = searchAdapter

        
    }
}