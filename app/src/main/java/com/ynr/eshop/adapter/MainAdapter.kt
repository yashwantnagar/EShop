package com.ynr.eshop.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ynr.eshop.R
import com.ynr.eshop.model.AllProduct
import com.ynr.eshop.ui.ProductDetailActivity

class MainAdapter(contexts : Context) : RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    var allProducts = mutableListOf<AllProduct>()
    val context = contexts


    fun setProducts(allProduct : List<AllProduct>) {

        this.allProducts = allProduct.toMutableList()
        notifyDataSetChanged()

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.single_item,parent,false)
        return ViewHolder(view)

    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val allProduct = allProducts[position]

        Glide.with(holder.itemView).load(allProduct.image).into(holder.product_image)

        holder.product_title.text = allProduct.title
        holder.product_price.text = allProduct.price.toString() + " USD "
        holder.rating.text = allProduct.rating?.rate.toString()
        holder.review.text = allProduct.rating?.count.toString() + " Reviews"

        holder.itemView.setOnClickListener(View.OnClickListener {


            val intent = Intent(context,ProductDetailActivity::class.java)
            intent.putExtra("id",allProduct.id)
            intent.putExtra("price",allProduct.price)
            intent.putExtra("image",allProduct.image)
            intent.putExtra("title",allProduct.title)
            intent.putExtra("category",allProduct.category)
            intent.putExtra("description",allProduct.description)
            intent.putExtra("rate", allProduct.rating?.rate)
            intent.putExtra("count", allProduct.rating?.count)
            context.startActivity(intent)


        })

    }

    override fun getItemCount(): Int {

        return allProducts.size

    }



    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val product_image : AppCompatImageView = itemView.findViewById(R.id.product_image)
        val product_title : AppCompatTextView = itemView.findViewById(R.id.product_title)
        val product_price : AppCompatTextView = itemView.findViewById(R.id.product_price)
        val rating : AppCompatTextView = itemView.findViewById(R.id.rating)
        val review : AppCompatTextView = itemView.findViewById(R.id.review)


    }

}