package io.github.myolwin00.sunshine.utils

import android.content.Context
import android.util.Log
import io.github.myolwin00.sunshine.R
import io.github.myolwin00.sunshine.data.Weather
import timber.log.Timber
import java.lang.StringBuilder
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by myolwin00 on 11/13/17.
 */
fun getWeatherDescStr(weathers: List<Weather>?) = weathers?.map {
    it.mDescription
}?.joinToString(" ") ?: ""


fun getWeatherDrawable(weatherId: Int?) = when (weatherId) {
    in 200..232 -> R.drawable.art_storm
    in 300..321 -> R.drawable.art_light_rain
    in 500..504 -> R.drawable.art_rain
    511 -> R.drawable.art_snow
    in 520..531 -> R.drawable.art_rain
    in 600..622 -> R.drawable.art_snow
    in 701..761 -> R.drawable.art_fog
    761 or 771 or 781 -> R.drawable.art_storm
    800 -> R.drawable.art_clear
    801 -> R.drawable.art_light_clouds
    in 802..804 -> R.drawable.art_clouds
    in 900..906 -> R.drawable.art_storm
    in 958..962 -> R.drawable.art_storm
    in 951..957 -> R.drawable.art_clear
    else -> 0
}

fun formatDate(millisecond: Long): String {
    val sdf = SimpleDateFormat("EEE, d MMM")
    return sdf.format(getActualMillisecond(millisecond))
}

private fun getActualMillisecond(millisecond: Long): Long {
    return millisecond * 1000
}

fun formatTemperature(context: Context, temperature: Double?): String {
    return String.format(context.getString(R.string.format_temperature), temperature)
}