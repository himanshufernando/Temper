package com.project.temper

import android.app.Application
import android.content.Context
import androidx.multidex.MultiDex
import com.project.temper.services.api.APIInterface
import com.project.temper.services.api.ApiClient
import okhttp3.internal.Internal.instance

class Temper : Application() {


    lateinit var apiInterface: APIInterface

    init {
        instance = this
    }

    companion object {
        private var instance: Temper? = null

        fun applicationContext(): Context {
            return instance!!.applicationContext
        }


    }


    override fun onCreate() {
        super.onCreate()

        val context: Context = Temper.applicationContext()
        apiInterface = ApiClient.client()

    }

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        MultiDex.install(this)

    }

    override fun onTerminate() {
        super.onTerminate()
    }

}