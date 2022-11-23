package com.ynr.eshop.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.card.MaterialCardView
import com.google.android.material.imageview.ShapeableImageView
import com.ynr.eshop.R

class WishlistAdapter : RecyclerView.Adapter<WishlistAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context).
        inflate(R.layout.wishlist_item,parent,false)
        return WishlistAdapter.ViewHolder(view)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {

        return 10

    }


    class ViewHolder (itemView : View) : RecyclerView.ViewHolder(itemView){

        val itemCard : MaterialCardView = itemView.findViewById(R.id.card_item)
        val productImage : AppCompatImageView = itemView.findViewById(R.id.product_image)
        val productTitle : TextView = itemView.findViewById(R.id.product_title)
        val productPrice : TextView = itemView.findViewById(R.id.product_price)
        val productRating : TextView = itemView.findViewById(R.id.product_rating)
        val productReview : TextView = itemView.findViewById(R.id.product_review)
        val deleteBtn : AppCompatImageView = itemView.findViewById(R.id.deleteBtn)

    }

}