package com.ynr.eshop.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.android.material.card.MaterialCardView
import com.ynr.eshop.R
import com.ynr.eshop.database.Product
import com.ynr.eshop.util.OnClickItem
import com.ynr.eshop.viewmodel.CartViewModel

class CartAdapter(
    private val context : Context,
    private val product : List<Product>,
    private val cartViewModel : CartViewModel
)
    : RecyclerView.Adapter<CartAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context).
        inflate(R.layout.cart_item,parent,false)
        return ViewHolder(view)

    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val product = product[position]

        Glide.with(holder.itemView).load(product.image).into(holder.productImage)

        holder.productTitle.text = product.title
        holder.productPrice.text = product.price.toString() + " USD "
        holder.productQuantity.text = "1"

        holder.productCard.setOnClickListener(View.OnClickListener {


        })


        holder.deleteBtn.setOnClickListener(View.OnClickListener {

            cartViewModel.deleteProduct(product)
            notifyDataSetChanged()
            notifyItemChanged(position)

            Log.e("TAG", "onBindViewHolder: ${product.id} is Deleted" )

        })


    }


    override fun getItemCount(): Int {

        return product.size

    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val productCard : MaterialCardView = itemView.findViewById(R.id.card_item)
        val productImage : AppCompatImageView = itemView.findViewById(R.id.product_image)
        val productTitle : TextView = itemView.findViewById(R.id.product_title)
        val productPrice : TextView = itemView.findViewById(R.id.product_price)
        val productQuantity : TextView = itemView.findViewById(R.id.product_quantity)
        val removeBtn : AppCompatImageView = itemView.findViewById(R.id.removeBtn)
        val addBtn : AppCompatImageView = itemView.findViewById(R.id.addBtn)
        val deleteBtn : AppCompatImageView = itemView.findViewById(R.id.deleteBtn)

    }

}