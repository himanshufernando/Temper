package com.project.temper.modeldata


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable
 data class Jobs(
     @SerializedName("2019-10-14")
     @Expose
    var jobsDetails: ArrayList<JobsDetails> = ArrayList<JobsDetails>()
 ){
}