package io.github.myolwin00.sunshine.data

import android.arch.persistence.room.Embedded
import android.arch.persistence.room.Entity
import android.arch.persistence.room.Ignore
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.SerializedName

/**
 * Created by myolwin00 on 11/9/17.
 */
@Entity(tableName = "forecasts")
class Forecast {

    @PrimaryKey
    @SerializedName("dt")
    var mDt: Long? = null

    @SerializedName("dt_txt")
    var mDtTxt: String? = null

    @Embedded
    @SerializedName("main")
    var mMain: Main? = null

    @Ignore
    @SerializedName("weather")
    var mWeather: List<Weather>? = null
}