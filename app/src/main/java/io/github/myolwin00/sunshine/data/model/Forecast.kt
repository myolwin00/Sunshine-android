package io.github.myolwin00.sunshine.data.model

import io.github.myolwin00.sunshine.app.utils.formatDate
import io.github.myolwin00.sunshine.app.utils.getWeatherDrawable

data class Forecast(
        val dt: Long,
        val weatherId: Int,
        val weatherDesc: String,
        val tempMax: Float,
        val tempMin: Float
) {

    fun getWeatherIcon(): Int {
        return getWeatherDrawable(weatherId)
    }

    fun getReadableDate(): String {
        return formatDate(dt)
    }
}