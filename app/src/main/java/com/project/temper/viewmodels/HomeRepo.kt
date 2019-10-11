package com.project.temper.viewmodels

import android.app.Application
import android.widget.Toast
import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import com.project.temper.modeldata.Data
import com.project.temper.services.api.APIInterface
import com.project.temper.services.api.ApiClient
import com.project.temper.services.network.InternetConnection
import com.project.temper.services.network.NetworkErrorHandler
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class HomeRepo  (application: Application){

    var app: Application = application
    var apiInterface: APIInterface = ApiClient.client(application)
    var networkErrorHandler: NetworkErrorHandler = NetworkErrorHandler()



    fun getJobs(loding : ObservableField<Boolean>) : MutableLiveData<Data> {

        val result = MutableLiveData<Data>()
        var data = Data()

        loding.set(true)

        if (!InternetConnection.checkInternetConnection(app))
            Toast.makeText(app, "No internet connection you will miss the latest information ", Toast.LENGTH_LONG).show()

        apiInterface.getJobs()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<Data> {
                override fun onSubscribe(d: Disposable) {
                }
                override fun onNext(log: Data) {
                    data = log
                }
                override fun onError(e: Throwable) {
                    data.respondStatus = false
                    data.networkError = networkErrorHandler(e)
                    result.postValue(data)
                   loding.set(false)
                }
                override fun onComplete() {
                    result.postValue(data)
                    loding.set(false)
                }
            })

        return result


    }


}