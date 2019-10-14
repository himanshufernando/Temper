package com.project.temper.services.network

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import com.project.temper.Temper

object InternetConnection {

    var app : Context = Temper.applicationContext()

    fun checkInternetConnection(): Boolean {
        var isConnexted = false

        val connect = app.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        val activeNetwork = connect.activeNetworkInfo
        if (activeNetwork != null) {
            if (activeNetwork.type == ConnectivityManager.TYPE_WIFI) {
                isConnexted = true
            } else if (activeNetwork.type == ConnectivityManager.TYPE_MOBILE) {
                isConnexted = true
            }
        } else {
            isConnexted = false
        }
        return isConnexted
    }
}