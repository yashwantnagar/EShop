package com.ynr.eshop.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ynr.eshop.R
import com.ynr.eshop.model.AllProduct

class HomeAdapter() : RecyclerView.Adapter<HomeAdapter.ViewHolder>() {

    var allProducts = mutableListOf<AllProduct>()

    fun setProducts(allProduct: List<AllProduct>) {

        this.allProducts = allProduct.toMutableList()
        notifyDataSetChanged()

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.single_item,parent,false)
        return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val allProduct = allProducts[position]

        Glide.with(holder.itemView).load(allProduct.image).into(holder.product_image)

        holder.product_title.text = allProduct.title
        holder.product_price.setText(allProduct.price.toString())
        holder.rating.setText(allProduct.rating?.rate.toString())
        holder.review.setText(allProduct.rating?.count.toString() + " Reviews")


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