package com.project.temper.views.login

import android.app.ActivityOptions
import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.project.temper.R
import com.project.temper.views.home.activity.HomeActivity

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }



    override fun onBackPressed() {

        val intent = Intent(this, HomeActivity::class.java)
        val bndlanimation = ActivityOptions.makeCustomAnimation(this, R.anim.fade_in, R.anim.fade_out).toBundle()
        startActivity(intent, bndlanimation)
        this.finish()

    }
}
