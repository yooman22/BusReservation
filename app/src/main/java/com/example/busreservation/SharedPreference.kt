package com.example.busreservation

import android.app.Application
import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import java.math.BigInteger

class SharedPreference : Application(){
    companion object {
        lateinit var prefs: PrefsManager
    }

    override fun onCreate() {
        prefs = PrefsManager(applicationContext)
        super.onCreate()
    }

}

class PrefsManager(context: Context) {
    private val prefs = context.getSharedPreferences("pref_name", Context.MODE_PRIVATE)

    fun getString(key: String, defValue: String) : String {
        return prefs.getString(key, defValue).toString()
    }

    fun setString(key: String, value: String) {
        prefs.edit().putString(key, value).apply()
    }

    fun getBool(key: String, defValue: Boolean) : Boolean {
        return prefs.getBoolean(key, defValue)
    }

    fun setBool(key: String, value: Boolean) {
        prefs.edit().putBoolean(key, value).apply()
    }

    fun setBigInteger(key: String , value : Long){
        prefs.edit().putLong(key, value).apply()
    }

    fun getBigInteger(key: String , value : Long) : Long {
        return prefs.getLong(key, -1)
    }

}