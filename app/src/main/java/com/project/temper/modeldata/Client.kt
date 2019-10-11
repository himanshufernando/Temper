package com.project.temper.modeldata

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Client(
    @SerializedName("name")
    @Expose
    var clientName: String = "",
    @SerializedName("id")
    @Expose
    var clientID: String = "",
    @SerializedName("description")
    @Expose
    var clientDescription: String = ""



) {}