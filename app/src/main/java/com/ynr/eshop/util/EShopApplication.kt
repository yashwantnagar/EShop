package com.ynr.eshop.util

import android.app.Application
import com.ynr.eshop.database.ProductDatabase

class EShopApplication : Application() {


    override fun onCreate() {
        super.onCreate()

        SharedPref.init(this)

        initialize()

//        mInstance = this

        //new SharedPref(AppController.this);
//        SharedPref.init(this)

        //this code for font.
        //TypefaceUtil.overrideFont(getApplicationContext(), "SERIF", "fonts/Roboto-BlackItalic.ttf");

    }

    private fun initialize() {

        val database = ProductDatabase.getDatabase(this)

    }


//    companion object {
//
//        private var mInstance: MyApplication? = null
//
//        @Synchronized
//        fun getInstance(applicationContext: Context?): MyApplication? {
//            return mInstance
//        }
//
//    }

}