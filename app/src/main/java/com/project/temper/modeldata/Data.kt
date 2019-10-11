package com.project.temper.modeldata
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("data")
    @Expose
    var jobs: Jobs = Jobs(),
    var respondStatus: Boolean = true,
    var networkError: NetworkError = NetworkError()

){
}