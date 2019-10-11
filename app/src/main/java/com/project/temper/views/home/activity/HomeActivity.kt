package com.project.temper.views.home.activity

import android.app.ActivityOptions
import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.project.temper.R
import com.project.temper.databinding.ActivityHomeBinding
import com.project.temper.modeldata.Data
import com.project.temper.modeldata.NetworkError
import com.project.temper.viewmodels.HomeModelView
import com.project.temper.views.home.adapter.JobAdapter
import com.project.temper.views.login.LoginActivity
import com.project.temper.views.singup.SingUpActivity

import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    lateinit var viewModelHome: HomeModelView
    lateinit var bindingHome: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingHome = DataBindingUtil.setContentView(this, R.layout.activity_home)
        viewModelHome = ViewModelProviders.of(this).get(HomeModelView::class.java)
        bindingHome.jobs = viewModelHome
    }


    override fun onStart() {
        super.onStart()

        getJobs()


        swiperefresh_joblist.setOnRefreshListener {
            getJobs()
        }

    }



    fun signupOnClick(view: View) {
        val intentSingUp = Intent(this, SingUpActivity::class.java)
        val bndlanimationSingUp = ActivityOptions.makeCustomAnimation(this, R.anim.fade_in, R.anim.fade_out).toBundle()
        startActivity(intentSingUp, bndlanimationSingUp)
        this.finish()
    }
    fun loginOnClick(view: View) {
        val intentLogin = Intent(this, LoginActivity::class.java)
        val bndlanimationLogin = ActivityOptions.makeCustomAnimation(this, R.anim.fade_in, R.anim.fade_out).toBundle()
        startActivity(intentLogin, bndlanimationLogin)
        this.finish()
    }


    private fun getJobs(){
        viewModelHome!!.getAllJobs().observe(this, Observer<Data> {
            it?.let { result ->
                swiperefresh_joblist.isRefreshing = false
                if (result.respondStatus) {
                    recyclerView_jobs.apply {
                        adapter = JobAdapter(result.jobs.jobsDetails,this@HomeActivity)
                    }
                } else {
                    errorAlertDialog(result.networkError)
                }
            }
        })


    }

    fun errorAlertDialog(networkError: NetworkError) {
        val alertDialogBuilder = AlertDialog.Builder(this)
        alertDialogBuilder.setTitle(networkError.errorTitle)
        alertDialogBuilder.setMessage(networkError.errorMessage)
        alertDialogBuilder.setPositiveButton(
            "OK",
            DialogInterface.OnClickListener { _, _ -> return@OnClickListener })
        alertDialogBuilder.show()
    }

    override fun onBackPressed() {
        val alertDialogBuilder = AlertDialog.Builder(this)
        alertDialogBuilder.setTitle("Exit!")
        alertDialogBuilder.setMessage("Do you really want to exit ?")
        alertDialogBuilder.setPositiveButton(
            "YES"
        ) { _, _ -> super.onBackPressed() }
        alertDialogBuilder.setNegativeButton(
            "NO",
            DialogInterface.OnClickListener { _, _ -> return@OnClickListener })
        alertDialogBuilder.show()

    }
}
