package com.project.temper.modeldata

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class JobsDetails(

    @SerializedName("title")
    @Expose
    var jobTitle: String = "",

    @SerializedName("id")
    @Expose
    var jobID: Int = 0,

    @SerializedName("max_possible_earnings_hour")
    @Expose
    var jobMaxPossibleEarningsHour: Double = 0.0,
    @SerializedName("max_possible_earnings_total")
    @Expose
    var jobMaxPossibleEarningsTotal: Double = 0.0,

    @SerializedName("client")
    @Expose
    var jobClient: Client = Client(),

    @SerializedName("job_category")
    @Expose
    var jobCategory: JobCategory =JobCategory(),

    @SerializedName("open_positions")
    @Expose
    var jobOpenPositions: Int = 0,

    @SerializedName("photo")
    @Expose
    var photo: String = "",

    @SerializedName("shifts")
    @Expose
    var shifts: ArrayList<Shifts> = ArrayList<Shifts>()


) {



}