package com.project.temper.viewmodels

import android.app.Application
import android.content.Context
import android.widget.Toast
import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import com.project.temper.Temper
import com.project.temper.modeldata.Data
import com.project.temper.services.api.APIInterface
import com.project.temper.services.api.ApiClient
import com.project.temper.services.network.InternetConnection
import com.project.temper.services.network.NetworkErrorHandler
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main

class HomeRepo  (val apiInterface: APIInterface){



    var networkErrorHandler: NetworkErrorHandler = NetworkErrorHandler()


    var job : CompletableJob? = null






/*    fun getJobs(loding : ObservableField<Boolean>) : MutableLiveData<Data> {
        job = Job()
        return object : MutableLiveData<Data>(){
            override fun onActive() {
                super.onActive()
                job?.let { job ->
                    CoroutineScope(IO + job).launch {
                        val res = apiInterface.getJobs()
                        withContext(Main){
                            value = res
                            job.complete()
                        }

                    }

                }

            }

        }

    }*/






   fun getJobs(loding : ObservableField<Boolean>) : MutableLiveData<Data> {

        val result = MutableLiveData<Data>()
        var data = Data()

        loding.set(true)


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