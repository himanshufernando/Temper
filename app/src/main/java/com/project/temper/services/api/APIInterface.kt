package com.project.temper.services.api

import com.project.temper.modeldata.Data
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface APIInterface {



    @GET("contractor/shifts")
    fun getJobs(): Observable<Data>


   /* @GET("contractor/shifts")
    suspend fun getJobs() : Data
*/


}