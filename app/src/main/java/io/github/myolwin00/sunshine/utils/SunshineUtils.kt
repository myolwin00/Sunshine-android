package io.github.myolwin00.sunshine.utils

import android.content.Context
import io.github.myolwin00.sunshine.R
import io.github.myolwin00.sunshine.data.Weather
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