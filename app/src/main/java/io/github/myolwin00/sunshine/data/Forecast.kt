package io.github.myolwin00.sunshine.data

import android.arch.persistence.room.*
import android.content.Context
import com.google.gson.annotations.SerializedName
import io.github.myolwin00.sunshine.data.source.local.WeatherTypeConverter
import io.github.myolwin00.sunshine.utils.SunshineUtils

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

    fun getWeatherIcon(): Int {
        return SunshineUtils.WeatherUtil.getWeatherIcon(mWeather?.get(0)?.mId)
    }

    fun getReadableDate(): String {
        return SunshineUtils.DateFormatUtil.formatDate(mDt!!)
    }

    fun getHighTemp(context: Context): String {
        return SunshineUtils.TemperatureUtil.formatTemperature(context, mMain?.mTempMax)
    }

    fun getLowTemp(context: Context): String {
        return SunshineUtils.TemperatureUtil.formatTemperature(context, mMain?.mTempMin)
    }

    fun getWeatherDesc(): String {
        return SunshineUtils.WeatherUtil.getWeatherDescStr(mWeather)
    }
}