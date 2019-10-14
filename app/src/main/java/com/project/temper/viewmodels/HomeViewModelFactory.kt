package com.project.temper.viewmodels

import androidx.lifecycle.LifecycleService
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.project.temper.services.api.APIInterface


class HomeViewModelFactory(
    private val apiService: APIInterface
): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeModelView::class.java!!)) {
            return HomeModelView(this.apiService) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}