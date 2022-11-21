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


class CartAdapter : RecyclerView.Adapter<CartAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context).
        inflate(R.layout.cart_item,parent,false)
        return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {


    }

    override fun getItemCount(): Int {

        return 5

    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val itemCard : MaterialCardView = itemView.findViewById(R.id.card_item)
        val productImage : AppCompatImageView = itemView.findViewById(R.id.product_image)
        val itemTitle : TextView = itemView.findViewById(R.id.product_title)
        val itemPrice : TextView = itemView.findViewById(R.id.product_price)
        val itemRating : TextView = itemView.findViewById(R.id.product_quantity)
        val removeBtn : AppCompatImageView = itemView.findViewById(R.id.removeBtn)
        val addBtn : AppCompatImageView = itemView.findViewById(R.id.addBtn)
        val deleteBtn : AppCompatImageView = itemView.findViewById(R.id.deleteBtn)

    }

}