package com.ynr.eshop.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import com.bumptech.glide.Glide
import com.google.android.material.button.MaterialButton
import com.ynr.eshop.R

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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_detail)


      /*  val bundle : Bundle? = intent.extras

        bundle?.let {

            bundle.apply {

                //Serializable Data
                val blog = getSerializable("blogData") as Blog?
                if (blog != null) {
                    textView.text = "Blog name is ${blog?.name}. Year started: ${blog?.year}"

                }

            }

        }*/


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



        val id = intent.getIntExtra("id",0)
        val price = intent.getIntExtra("price",0)
        val title = intent.getStringExtra("title").toString()
        val image = intent.getStringExtra("image").toString()
        val category = intent.getStringExtra("category").toString()
        val description = intent.getStringExtra("description").toString()
        val rate = intent.getIntExtra("rate",0)
        val count = intent.getIntExtra("count",0)

        Log.e(TAG, "ProductDetailActivity: $price -- $count -- $rate " )

        Glide.with(this).load(image).into(productImg)

        productTitle.text = title
        productPrice.text = price.toString()
        productDescription.text = description
        productRating.text = rate.toString()
        productReviews.text = count.toString() + " Reviews"

    }

}