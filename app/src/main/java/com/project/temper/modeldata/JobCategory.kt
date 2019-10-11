package com.project.temper.modeldata

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class JobCategory (

    @SerializedName("description")
    @Expose
    var jobCategoryDescription: String = "",
    @SerializedName("icon_path")
    @Expose
    var jobCategoryIconPath: String = "",
    @SerializedName("slug")
    @Expose
    var jobCategorySlug: String = ""

)
{}