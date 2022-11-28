package com.ynr.eshop.ui

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatImageView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.google.android.material.button.MaterialButton
import com.ynr.eshop.R
import com.ynr.eshop.database.Product
import com.ynr.eshop.viewmodel.CartViewModel

class ProductDetailActivity : AppCompatActivity() {

    val TAG = "ProductDetailActivity"

    lateinit var cartBtn : AppCompatImageView
    lateinit var backBtn : AppCompatImageView

    lateinit var productImg : AppCompatImageView
    lateinit var productLike : AppCompatImageView
    lateinit var productPrice : TextView
    lateinit var productTitle : TextView
    lateinit var productRating : TextView
    lateinit var productReviews : TextView
    lateinit var productDescription : TextView
    lateinit var addToCartBtn : MaterialButton

    private lateinit var cartViewModel : CartViewModel

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_detail)

        backBtn = findViewById(R.id.backBtn)
        cartBtn = findViewById(R.id.cartBtn)

        productImg = findViewById(R.id.product_image)
        productLike = findViewById(R.id.product_like)
        productPrice = findViewById(R.id.product_price)
        productTitle = findViewById(R.id.product_title)
        productRating = findViewById(R.id.product_rating)
        productReviews = findViewById(R.id.product_reviews)
        productDescription = findViewById(R.id.product_description)
        addToCartBtn = findViewById(R.id.add_to_cart_btn)


        val product_id = intent.getIntExtra("id",0)
        val price = intent.getDoubleExtra("price",0.0)
        val title = intent.getStringExtra("title").toString()
        val image = intent.getStringExtra("image").toString()
        val category = intent.getStringExtra("category").toString()
        val description = intent.getStringExtra("description").toString()
        val rate = intent.getDoubleExtra("rate",0.0)
        val count = intent.getIntExtra("count",0)

        Log.e(TAG, "ProductDetailActivity: $product_id -- $price -- $count -- $rate " )

        Glide.with(this).load(image).into(productImg)

        productTitle.text = title
        productPrice.text = "$price USD "
        productDescription.text = description
        productRating.text = rate.toString()
        productReviews.text = "$count Reviews"

        backBtn.setOnClickListener(View.OnClickListener {
            onBackPressedDispatcher.onBackPressed()
        })


        cartViewModel = ViewModelProvider(this).get(CartViewModel::class.java)


        cartViewModel.allProduct.observe(this, Observer {
            Log.e(TAG, "onCreate: ${it.size} --- $it" )

            for (its in it){
                if(its.product_id == product_id){

                    Log.e(TAG, "onCreate: GO TO CART ${its.product_id} " )
                    addToCartBtn.setText(R.string.go_to_cart)


                } /*else {

                    cartViewModel.insertProduct(Product(
                        product_id,title,price,description,category,image,rate,count
                    ))

                    addToCartBtn.setText(R.string.go_to_cart)
                    Log.e(TAG, "onCreate: NOT CART ${its.product_id}" )
                }*/
            }

        })


        addToCartBtn.setOnClickListener(View.OnClickListener {

            if(addToCartBtn.text == "Go to Cart"){
                Toast.makeText(this, "Product already available in the Cart",
                    Toast.LENGTH_SHORT).show()

                val intent = Intent(this,CartActivity::class.java)
                startActivity(intent)


            } else {

                cartViewModel.insertProduct(Product(
                    product_id,title,price,description,category,image,rate,count
                ))

                addToCartBtn.setText(R.string.go_to_cart)
            }

        })

    }

}