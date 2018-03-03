package io.github.myolwin00.sunshine.utils

import android.content.Context
import android.util.Log
import io.github.myolwin00.sunshine.R
import io.github.myolwin00.sunshine.data.Weather
import timber.log.Timber
import java.lang.StringBuilder
import java.text.SimpleDateFormat

/**
 * Created by myolwin00 on 11/13/17.
 */
class SunshineUtils {

    class WeatherUtil {
        companion object {

            fun getWeatherDescStr(weathers: List<Weather>?): String {

                if (weathers == null) {
                    return ""
                }

                val builder = StringBuilder()
                for (weather in weathers) {
                    builder.append(" ").append(weather.mDescription)
                }
                return builder.toString()
            }

            fun getWeatherIcon(weatherId: Int?): Int {

                if (weatherId in 200..232) {
                    return R.drawable.art_storm
                } else if (weatherId in 300..321) {
                    return R.drawable.art_light_rain
                } else if (weatherId in 500..504) {
                    return R.drawable.art_rain
                } else if (weatherId == 511) {
                    return R.drawable.art_snow
                } else if (weatherId in 520..531) {
                    return R.drawable.art_rain
                } else if (weatherId in 600..622) {
                    return R.drawable.art_snow
                } else if (weatherId in 701..761) {
                    return R.drawable.art_fog
                } else if (weatherId == 761 || weatherId == 771 || weatherId == 781) {
                    return R.drawable.art_storm
                } else if (weatherId == 800) {
                    return R.drawable.art_clear
                } else if (weatherId == 801) {
                    return R.drawable.art_light_clouds
                } else if (weatherId in 802..804) {
                    return R.drawable.art_clouds
                } else if (weatherId in 900..906) {
                    return R.drawable.art_storm
                } else if (weatherId in 958..962) {
                    return R.drawable.art_storm
                } else if (weatherId in 951..957) {
                    return R.drawable.art_clear
                }

                Timber.e("Unknown Weather: %i", weatherId)
                return 0
            }
        }
    }

    class DateFormatUtil {

        companion object {
            fun formatDate(millisec: Long): String {
                val sdf = SimpleDateFormat("EEE, d MMM")
                return sdf.format(getActualMillisec(millisec))
            }

            private fun getActualMillisec(millisec: Long): Long {
                return millisec * 1000
            }
        }
    }

    class TemperatureUtil {

        companion object {
            fun formatTemperature(context: Context, temperature: Double?): String {
                return String.format(context.getString(R.string.format_temperature), temperature)
            }
        }
    }
}