package com.project.temper

import android.app.Application
import android.content.Context
import com.project.temper.modeldata.Data
import com.project.temper.services.api.APIInterface
import com.project.temper.viewmodels.HomeModelView
import com.project.temper.viewmodels.HomeRepo
import io.reactivex.Observable
import org.junit.Test
import androidx.lifecycle.Observer

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mock

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import io.reactivex.Maybe
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.plugins.RxJavaPlugins
import io.reactivex.schedulers.Schedulers
import org.mockito.ArgumentMatchers

import retrofit2.Response
import org.mockito.Mockito
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(JUnit4::class)
class HomeRepoUnitTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()


    @Mock
    lateinit var aPIInterface: APIInterface


    lateinit var homeRepo: HomeModelView


    @Before
    @Throws(Exception::class)
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        this.homeRepo = HomeModelView(this.aPIInterface)
        RxJavaPlugins.setIoSchedulerHandler { Schedulers.trampoline() }
        RxJavaPlugins.setComputationSchedulerHandler { Schedulers.trampoline() }
        RxJavaPlugins.setNewThreadSchedulerHandler { Schedulers.trampoline() }
        RxAndroidPlugins.setInitMainThreadSchedulerHandler { Schedulers.trampoline() }
    }

    @Test
    fun fetchValidDataShouldLoadIntoView() {
        var resposndData = Data()
        `when`(aPIInterface.getJobs())
            .thenReturn(Observable.just(resposndData))
        this.homeRepo.getAllJobs()
    }

    @Test
    fun fetchValidDataShouldLoad() {

        var resposndData = Data()
        `when`(aPIInterface.getJobs())
            .thenReturn(Observable.just(resposndData))
        this.homeRepo.getAllJobs()

        val observer = mock(Observer::class.java) as Observer<Data>
        this.homeRepo.getAllJobs().observeForever(observer)

        this.homeRepo.getAllJobs()
        assertNotNull(this.homeRepo.getAllJobs().value)

    }

}
