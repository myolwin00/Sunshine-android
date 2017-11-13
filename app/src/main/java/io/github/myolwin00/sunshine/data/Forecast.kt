package io.github.myolwin00.sunshine.data

import android.arch.persistence.room.*
import com.google.gson.annotations.SerializedName
import io.github.myolwin00.sunshine.data.source.local.WeatherTypeConverter

/**
 * Created by myolwin00 on 11/9/17.
 */
@Entity(tableName = "forecasts")
@TypeConverters(WeatherTypeConverter::class)
class Forecast {

    @PrimaryKey
    @SerializedName("dt")
    var mDt: Long? = null

    @SerializedName("dt_txt")
    var mDtTxt: String? = null

    @Embedded
    @SerializedName("main")
    var mMain: Main? = null

    @SerializedName("weather")
    var mWeather: List<Weather>? = null
}