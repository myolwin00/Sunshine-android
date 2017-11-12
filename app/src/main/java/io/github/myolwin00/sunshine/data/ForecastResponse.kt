package io.github.myolwin00.sunshine.data

import com.google.gson.annotations.SerializedName

data class ForecastResponse (
    @SerializedName("cnt") var mCnt: Long,
    @SerializedName("cod") var mCod: String,
    @SerializedName("list") var mForecast: List<Forecast>,
    @SerializedName("message") var mMessage: Double
)