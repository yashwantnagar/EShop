package com.ynr.eshop.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.widget.AppCompatImageView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ynr.eshop.R
import com.ynr.eshop.adapter.MainAdapter
import com.ynr.eshop.api.RetrofitClient
import com.ynr.eshop.repository.HomeRepository
import com.ynr.eshop.viewmodel.HomeViewModel
import com.ynr.eshop.viewmodel.ViewModelFactory

class MainActivity : AppCompatActivity(), OnClickListener {


    lateinit var itemRecyclerView : RecyclerView
    lateinit var progressBar : ProgressBar

    private val TAG = "MainActivity"

    lateinit var homeViewModel : HomeViewModel
    private val retrofitClient = RetrofitClient.getInstance()

    lateinit var homeAdapter: MainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val searchItem : AppCompatImageView = findViewById(R.id.home_search)
        val cartItem : AppCompatImageView = findViewById(R.id.home_cart)
        val profileImage : AppCompatImageView = findViewById(R.id.profileImage)

        searchItem.setOnClickListener(this)
        cartItem.setOnClickListener(this)
//        profileImage.setOnClickListener(this)

        itemRecyclerView = findViewById(R.id.home_recycler_view)
        progressBar = findViewById(R.id.progressBar)

        itemRecyclerView.setHasFixedSize(true)
        itemRecyclerView.layoutManager = GridLayoutManager(this,2)


        homeViewModel = ViewModelProvider(this,
            ViewModelFactory(HomeRepository(retrofitClient))
        ).get(HomeViewModel::class.java)


        homeViewModel.productLiveData.observe(this, Observer {

            Log.e(TAG, "onViewCreated: $it")

            homeAdapter = MainAdapter(this,it)
            itemRecyclerView.adapter = homeAdapter


        })

        homeViewModel.errorMessage.observe(this, Observer {

            Toast.makeText(this,it,Toast.LENGTH_SHORT).show()
            Log.e(TAG, "onViewCreated: $it")

        })

        homeViewModel.loading.observe(this, Observer{

            if (it) {
                progressBar.visibility = View.VISIBLE
            } else {
                progressBar.visibility = View.GONE
            }

        })

        homeViewModel.productLiveData

    }

    override fun onClick(v: View?) {

        when(v?.id) {

            R.id.home_search -> {
                val intent = Intent(this,SearchActivity::class.java)
                startActivity(intent)
            }

            R.id.home_cart -> {
                val intent = Intent(this,CartActivity::class.java)
                startActivity(intent)
            }

            R.id.profileImage -> {
                val intent = Intent(this,ProfileActivity::class.java)
                startActivity(intent)
            }
        }

    }

}