package com.ynr.eshop.util

import android.app.Application

class EShopApplication : Application() {


    override fun onCreate() {
        super.onCreate()

//        initialize(application = Application())

//        mInstance = this

        //new SharedPref(AppController.this);
//        SharedPref.init(this)

        //this code for font.
        //TypefaceUtil.overrideFont(getApplicationContext(), "SERIF", "fonts/Roboto-BlackItalic.ttf");

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