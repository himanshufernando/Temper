package com.project.temper.views.home.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.project.temper.BR
import com.project.temper.R

import com.project.temper.modeldata.JobsDetails

class JobAdapter(val data: ArrayList<JobsDetails>, val context: Context) : RecyclerView.Adapter<JobAdapter.JobAdapterViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JobAdapterViewHolder {
        val layoutInflater = LayoutInflater.from(context)
        val binding: ViewDataBinding = DataBindingUtil.inflate(layoutInflater, R.layout.listview_jobs, parent, false)
        return JobAdapterViewHolder(binding)
    }
    override fun getItemCount(): Int = data.size
    override fun onBindViewHolder(holder: JobAdapterViewHolder, position: Int) = holder.bind(data[position])
    inner class JobAdapterViewHolder(val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(data: Any) {
            binding.setVariable(BR.item, data)
            binding.executePendingBindings()
        }
    }
}

