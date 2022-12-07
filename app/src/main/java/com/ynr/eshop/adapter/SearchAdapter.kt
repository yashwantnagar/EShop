package com.ynr.eshop.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.android.material.imageview.ShapeableImageView
import com.ynr.eshop.R
import com.ynr.eshop.model.AllProduct

class SearchAdapter(private val context: Context,
                    private var products: List<AllProduct>)
    : RecyclerView.Adapter<SearchAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context).
        inflate(R.layout.search_item,parent,false)
        return ViewHolder(view)

    }


    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val product = products[position]

        Glide.with(context).load(product.image).into(holder.productImage)

        holder.productTitle.text = product.title
        holder.productPrice.text = product.price.toString() + " USD "
        holder.productRating.text = product.rating?.rate.toString()
        holder.productReview.text = product.rating?.count.toString() + " Reviews"

    }


    override fun getItemCount(): Int {

        return products.size

    }


    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

        val productImage : ShapeableImageView = itemView.findViewById(R.id.product_image)
        val productTitle : TextView = itemView.findViewById(R.id.product_title)
        val productPrice : TextView = itemView.findViewById(R.id.product_price)
        val productRating : TextView = itemView.findViewById(R.id.product_rating)
        val productReview : TextView = itemView.findViewById(R.id.product_review)

    }

}