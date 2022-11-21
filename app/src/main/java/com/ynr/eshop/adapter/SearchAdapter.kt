package com.ynr.eshop.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.card.MaterialCardView
import com.google.android.material.imageview.ShapeableImageView
import com.ynr.eshop.R

class SearchAdapter : RecyclerView.Adapter<SearchAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context).
        inflate(R.layout.search_item,parent,false)
        return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {


    }

    override fun getItemCount(): Int {

        return 10

    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val itemCard : MaterialCardView = itemView.findViewById(R.id.card_item)
        val itemImage : ShapeableImageView = itemView.findViewById(R.id.item_image)
        val itemTitle : TextView = itemView.findViewById(R.id.item_title)
        val itemPrice : TextView = itemView.findViewById(R.id.item_price)
        val itemRating : TextView = itemView.findViewById(R.id.item_rating)
        val itemReview : TextView = itemView.findViewById(R.id.item_review)

    }

}