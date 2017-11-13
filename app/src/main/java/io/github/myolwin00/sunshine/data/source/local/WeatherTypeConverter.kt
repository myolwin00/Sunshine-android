package io.github.myolwin00.sunshine.data.source.local

import android.arch.persistence.room.TypeConverter
import com.google.gson.Gson
import io.github.myolwin00.sunshine.data.Weather
import com.google.gson.reflect.TypeToken




/**
 * Created by myolwin00 on 11/13/17.
 */
class WeatherTypeConverter {

    @TypeConverter
    fun toStr(weathers: List<Weather>): String {
        return Gson().toJson(weathers)
    }

    @TypeConverter
    fun toList(weatherStr: String): List<Weather> {
        return Gson().fromJson(weatherStr, object : TypeToken<List<Weather>>(){}.type)
    }
}