package com.ynr.eshop.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ynr.eshop.R
import com.ynr.eshop.adapter.HomeAdapter
import com.ynr.eshop.api.RetrofitClient
import com.ynr.eshop.repository.HomeRepository
import com.ynr.eshop.viewmodel.HomeViewModel
import com.ynr.eshop.viewmodel.ViewModelFactory


class HomeFragment : Fragment() {

    lateinit var itemRecyclerView : RecyclerView
    lateinit var progressBar : ProgressBar

    private val TAG = "MainActivity"

//    private lateinit var binding : FragmentHomeBinding
    lateinit var homeViewModel : HomeViewModel
    private val retrofitClient = RetrofitClient.getInstance()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        itemRecyclerView = view.findViewById(R.id.home_recycler_view)
        progressBar = view.findViewById(R.id.progressBar)

        itemRecyclerView.setHasFixedSize(true)
        itemRecyclerView.layoutManager = GridLayoutManager(activity,2)


        homeViewModel = ViewModelProvider(this,
            ViewModelFactory(HomeRepository(retrofitClient))
        ).get(HomeViewModel::class.java)


//        binding.recyclerview.adapter = adapter

        homeViewModel.allProductList.observe(viewLifecycleOwner, Observer {

            Log.e(TAG, "onViewCreated: $it")

            val homeAdapter = HomeAdapter()
            itemRecyclerView.adapter = homeAdapter

            homeAdapter.setProducts(it)


        })

        homeViewModel.errorMessage.observe(viewLifecycleOwner, Observer {

            Log.e(TAG, "onViewCreated: $it")

        })

        homeViewModel.loadingProgressBar.observe(viewLifecycleOwner,Observer{

            if (it) {
                progressBar.visibility = View.VISIBLE
            } else {
                progressBar.visibility = View.GONE
            }

        })

//        homeViewModel.allProductList()

//        val homeAdapter = HomeAdapter()
//        itemRecyclerView.adapter = homeAdapter


    }

}