package com.ynr.eshop.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Product::class], version = 1, exportSchema = false)
abstract class ProductDatabase : RoomDatabase() {

    abstract fun getProductDao() : ProductDao

    companion object{

        private var INSTANCE : ProductDatabase? = null

        fun getDatabase(context: Context) : ProductDatabase {

            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ProductDatabase :: class.java,
                    "product_database"
                ).build()

                INSTANCE = instance
                instance

            }

        }

    }


    /*abstract fun messageDao(): MessageDao

    companion object {

        @Volatile
        private var INSTANCE: MessageDatabase? = null

        fun getDatabase(context: Context): MessageDatabase? {
            if (INSTANCE == null) {
                synchronized(MessageDatabase::class.java) {
                    if (INSTANCE == null) {
                        INSTANCE = Room.databaseBuilder(
                            context.applicationContext,
                            MessageDatabase::class.java, "message_database"
                        )
                            .build()
                    }
                }
            }
            return INSTANCE
        }
    }*/


}