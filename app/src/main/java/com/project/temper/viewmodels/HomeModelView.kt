package com.project.temper.viewmodels

import android.app.ActivityOptions
import android.app.Application
import android.content.Intent
import androidx.databinding.ObservableField
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.project.temper.R
import com.project.temper.modeldata.Data
import com.project.temper.services.api.APIInterface
import com.project.temper.views.home.activity.HomeActivity

class HomeModelView(val aPIInterface: APIInterface)  : ViewModel() {




    var homeRepository: HomeRepo = HomeRepo(aPIInterface)
    val isJobListLoading = ObservableField<Boolean>()





    fun getAllJobs(): MutableLiveData<Data> {
        return homeRepository.getJobs(isJobListLoading)
    }



}