package com.ynr.eshop.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.widget.AppCompatImageView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ynr.eshop.R
import com.ynr.eshop.adapter.CartAdapter
import com.ynr.eshop.database.Product
import com.ynr.eshop.util.OnClickItem
import com.ynr.eshop.viewmodel.CartViewModel

class CartActivity : AppCompatActivity() {

    private lateinit var cartRV : RecyclerView
    lateinit var cartAdapter : CartAdapter
    lateinit var backBtn : AppCompatImageView

    private lateinit var cartViewModel : CartViewModel

    val TAG = "CartActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

        cartRV = findViewById(R.id.cartRV)
        backBtn = findViewById(R.id.backBtn)

        cartRV.setHasFixedSize(true)
        cartRV.layoutManager = LinearLayoutManager(this)


        backBtn.setOnClickListener { onBackPressedDispatcher.onBackPressed() }

        cartViewModel = ViewModelProvider(this)[CartViewModel::class.java]


        cartViewModel.allProduct.observe(this, Observer {
            Log.e(TAG, "onCreate: ${it.size} --- $it" )

            if(it.isNotEmpty()){

                cartAdapter = CartAdapter(this,it,cartViewModel)
                cartRV.adapter = cartAdapter

            }
        })

     /*   val productDao = ProductDao()
        val cartRepository = CartRepository()

        cartViewModel = ViewModelProvider(this,CartModelFactory(cartRepository))
            .get(CartViewModel::class.java)
*/

    }


}