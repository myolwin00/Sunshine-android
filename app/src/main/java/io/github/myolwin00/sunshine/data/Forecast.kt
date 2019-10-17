package io.github.myolwin00.sunshine.data

import android.content.Context
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import io.github.myolwin00.sunshine.data.source.local.WeatherTypeConverter
import io.github.myolwin00.sunshine.utils.*

/**
 * Created by myolwin00 on 11/9/17.
 */
@Entity(tableName = "forecasts")
@TypeConverters(WeatherTypeConverter::class)
class Forecast {

    @PrimaryKey
    var mDt: Long? = null

    var mDtTxt: String? = null

    @Embedded
    var mMain: Main? = null

    var mWeather: List<Weather>? = null

    fun getWeatherIcon(): Int {
        return getWeatherDrawable(mWeather?.get(0)?.mId)
    }

    fun getReadableDate(): String {
        return formatDate(mDt!!)
    }

    fun getHighTemp(context: Context): String {
        return formatTemperature(context, mMain?.mTempMax)
    }

    fun getLowTemp(context: Context): String {
        return formatTemperature(context, mMain?.mTempMin)
    }

    fun getWeatherDesc(): String {
        return getWeatherDescStr(mWeather)
    }
}

data class ForecastResponse(
        var mCnt: Long,
        var mCod: String,
        var mForecast: List<Forecast>,
        var mMessage: Double
)

class Main {
    var mGrndLevel: Double? = null
    var mHumidity: Long? = null
    var mPressure: Double? = null
    var mSeaLevel: Double? = null
    var mTemp: Double? = null
    var mTempKf: Double? = null
    var mTempMax: Double? = null
    var mTempMin: Double? = null
}

class Weather {
    var mDescription: String? = null
    var mIcon: String? = null
    var mId: Int? = null
    var mMain: String? = null
}