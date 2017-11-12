package io.github.myolwin00.sunshine.data

import com.google.gson.annotations.SerializedName

class Main {
    @SerializedName("grnd_level")
    var mGrndLevel: Double? = null
    @SerializedName("humidity")
    var mHumidity: Long? = null
    @SerializedName("pressure")
    var mPressure: Double? = null
    @SerializedName("sea_level")
    var mSeaLevel: Double? = null
    @SerializedName("temp")
    var mTemp: Double? = null
    @SerializedName("temp_kf")
    var mTempKf: Double? = null
    @SerializedName("temp_max")
    var mTempMax: Double? = null
    @SerializedName("temp_min")
    var mTempMin: Double? = null
}
