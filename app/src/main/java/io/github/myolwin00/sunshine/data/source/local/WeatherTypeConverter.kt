package io.github.myolwin00.sunshine.data.source.local

import androidx.room.TypeConverter
import io.github.myolwin00.sunshine.data.Weather

/**
 * Created by myolwin00 on 11/13/17.
 */
class WeatherTypeConverter {

    @TypeConverter
    fun toStr(weathers: List<Weather>): String {
        TODO("relation table")
    }

    @TypeConverter
    fun toList(weatherStr: String): List<Weather> {
        TODO("relation table")
    }
}