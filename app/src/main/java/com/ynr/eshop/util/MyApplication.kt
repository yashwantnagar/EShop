package com.ynr.eshop.util

import android.app.Application
import android.content.Context
import android.util.Log

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()

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