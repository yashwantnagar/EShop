package com.ynr.eshop.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ynr.eshop.R
import com.ynr.eshop.adapter.SearchAdapter
import com.ynr.eshop.api.RetrofitInstance
import com.ynr.eshop.repository.SearchRepository
import com.ynr.eshop.viewmodel.SearchViewModel

class SearchActivity : AppCompatActivity() {

    private lateinit var searchRV : RecyclerView
    private lateinit var searchView : SearchView
    private lateinit var searchAdapter : SearchAdapter
    lateinit var backBtn : AppCompatImageView
    private lateinit var progressBar : ProgressBar

    private lateinit var searchViewModel : SearchViewModel
    private var retrofitInstance = RetrofitInstance


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        searchRV = findViewById(R.id.searchRV)
        searchView = findViewById(R.id.search_view)
        backBtn = findViewById(R.id.backBtn)
        progressBar = findViewById(R.id.progressBar)

        searchRV.setHasFixedSize(true)
        searchRV.layoutManager = LinearLayoutManager(this)


        backBtn.setOnClickListener { onBackPressedDispatcher.onBackPressed() }


        searchViewModel = ViewModelProvider(this,
            SearchViewModel.SearchModelFactory(SearchRepository(retrofitInstance))
        )[SearchViewModel::class.java]


        searchViewModel.productLiveData.observe(this) {

            Log.e("TAG", "onViewCreated: $it")

            if (it.isNotEmpty()) {

                searchAdapter = SearchAdapter(this, it)
                searchRV.adapter = searchAdapter

            }

        }

        searchViewModel.errorMessage.observe(this) {

            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
            Log.e("TAG", "onViewCreated: $it")

        }

        searchViewModel.loading.observe(this) {

            if (it) {
                progressBar.visibility = View.VISIBLE
            } else {
                progressBar.visibility = View.GONE
            }

        }

    }

}



