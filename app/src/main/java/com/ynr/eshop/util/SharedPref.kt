package com.ynr.eshop.util

import android.content.Context
import android.content.SharedPreferences
import java.lang.RuntimeException

class SharedPref(context: Context) {

    private val sharedPreferences: SharedPreferences
    private val editor: SharedPreferences.Editor

    init {
        prefsHelper = this
        val prefsFile = context.packageName
        sharedPreferences = context.getSharedPreferences(prefsFile, Context.MODE_PRIVATE)
        editor = sharedPreferences.edit()
        editor.apply()
    }

    companion object {
        var prefsHelper: SharedPref? = null
            private set

        fun init(context: Context) {
            if (prefsHelper == null) {
                SharedPref(context)
            }
        }
    }

     fun delete(key: String?) {
        if (sharedPreferences.contains(key)) {
            editor.remove(key).commit()
        }
    }

    fun savePref(key: String?, value: Any?) {
        delete(key)
        if (value is Boolean) {
            editor.putBoolean(key, (value as Boolean?)!!)
        } else if (value is Int) {
            editor.putInt(key, (value as Int?)!!)
        } else if (value is Float) {
            editor.putFloat(key, (value as Float?)!!)
        } else if (value is Long) {
            editor.putLong(key, (value as Long?)!!)
        } else if (value is String) {
            editor.putString(key, value as String?)
        } else if (value is Enum<*>) {
            editor.putString(key, value.toString())
        } else if (value != null) {
            throw RuntimeException("Attempting to save non-primitive preference")
        }
        editor.commit()
    }

    fun <T> getPref(key: String?): T? {
        return sharedPreferences.all[key] as T?
    }

    fun <T> getPref(key: String?, defValue: T): T {
        val returnValue = sharedPreferences.all[key] as T?
        return returnValue ?: defValue
    }

    fun isPrefExists(key: String?): Boolean {
        return sharedPreferences.contains(key)
    }


}