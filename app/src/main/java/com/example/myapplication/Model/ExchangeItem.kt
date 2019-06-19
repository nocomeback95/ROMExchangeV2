package com.example.myapplication.Model

import com.google.gson.annotations.SerializedName

class ExchangeItem {
    @SerializedName("name")
    var itemName : String? = null
    @SerializedName("type")
    var itemType : String? = null
    @SerializedName("global")
    var globalItem : GlobalItem? = null
    @SerializedName("sea")
    var seaItem : SeaItem? = null
}