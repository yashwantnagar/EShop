package com.ynr.eshop.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cartItem")
data class Product(

    @ColumnInfo(name = "product_id")
    val product_id : Int? = null,

    @ColumnInfo(name = "product_title")
    val title : String? = null,

    @ColumnInfo(name = "product_price")
    val price : Double? = null,

    @ColumnInfo(name = "product_description")
    val description : String? = null,

    @ColumnInfo(name = "product_category")
    val category : String? = null,

    @ColumnInfo(name = "product_image")
    val image : String? = null,

    @ColumnInfo(name = "product_rating")
    val rating : Double? = null,

    @ColumnInfo(name = "product_count")
    val count : Int? = null

){
    @PrimaryKey(autoGenerate = true)
    val id : Int = 0
}
