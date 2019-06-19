package com.example.myapplication.Model

import com.google.gson.annotations.SerializedName

class SeaItem {
    @SerializedName("week")
    var seaWeek : SeaWeek? = null
    @SerializedName("latest")
    var latestPrice : String? = null
    @SerializedName("latest_time")
    var latesetTime : String? = null

    class SeaWeek {
        @SerializedName("change")
        var priceChange: String? = null
    }
}