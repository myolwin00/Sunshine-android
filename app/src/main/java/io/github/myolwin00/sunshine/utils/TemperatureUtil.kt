package io.github.myolwin00.sunshine.utils

import android.content.Context
import io.github.myolwin00.sunshine.R

/**
 * Created by myolwin00 on 11/13/17.
 */
class TemperatureUtil {

    companion object {
        fun formatTemperature(context: Context, temperature: Double?): String {
            return String.format(context.getString(R.string.format_temperature), temperature)
        }
    }
}