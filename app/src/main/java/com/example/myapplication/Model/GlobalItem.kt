package com.example.myapplication.Model

import com.google.gson.annotations.SerializedName

class GlobalItem {
    @SerializedName("week")
    var globalWeek : GlobalWeek? = null
    @SerializedName("latest")
    var latestPrice : String? = null
    @SerializedName("latest_time")
    var latesetTime : String? = null

    class GlobalWeek {
        @SerializedName("change")
        var priceChange: String? = null
    }
}