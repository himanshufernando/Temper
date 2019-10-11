package com.project.temper.modeldata

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Shifts(

    @SerializedName("id")
    @Expose
    var shiftsID: String = "",
    @SerializedName("tempers_needed")
    @Expose
    var shiftsTempers: Double = 0.0,
    @SerializedName("earnings_per_hour")
    @Expose
    var shiftEarningsPerHour: Double = 0.0,

    @SerializedName("duration")
    @Expose
    var shiftDuration: Int = 0,

    @SerializedName("currency")
    @Expose
    var shiftCurrency: String = "",
    @SerializedName("start_date")
    @Expose
    var shiftStartDate: String = "",

    @SerializedName("start_time")
    @Expose
    var shiftStartTime: String = "",

    @SerializedName("end_time")
    @Expose
    var shiftEndTime: String = ""


) {}