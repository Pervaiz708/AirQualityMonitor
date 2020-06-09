package com.piyushsatija.pollutionmonitor.model.properties

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Temperature {
    @SerializedName("v")
    @Expose
    var v: Double? = null

}