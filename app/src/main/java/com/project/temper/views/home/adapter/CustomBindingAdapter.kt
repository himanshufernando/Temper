package com.project.temper.views.home.adapter


import android.graphics.Bitmap
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.Target
import com.project.temper.R
import com.project.temper.modeldata.Shifts
import kotlin.math.roundToInt


object CustomBindingAdapter {
    @BindingAdapter("photo")
    @JvmStatic
    fun loadImage(view: ImageView, url: String) {
        Glide.with(view.context)
            .load(url)
            .placeholder(R.drawable.temper_logo)
            .centerCrop()
            .into(view)

    }

    @BindingAdapter("shifts")
    @JvmStatic
    fun setDuration(view : TextView, shifts: ArrayList<Shifts>) {
        view.text = shifts.last().shiftDuration.toString() + "KM"
    }

    @BindingAdapter("shiftstime")
    @JvmStatic
    fun setTime(view : TextView, shifts: ArrayList<Shifts>) {
        view.text = (shifts.last().shiftStartTime.toString() + " - " + shifts.last().shiftEndTime.toString())
    }


}