package io.github.myolwin00.sunshine.data.source.local

import android.arch.lifecycle.LiveData
import io.github.myolwin00.sunshine.data.Forecast

/**
 * Created by myolwin00 on 11/13/17.
 */
class WeatherLocalSource(forecastDao: ForecastDao) {

    private val forecastDao: ForecastDao = forecastDao

    fun getForecasts(): List<Forecast>? {
        return forecastDao.getForecasts()
    }

    fun saveForecasts(forecasts: List<Forecast>) {
        forecastDao.saveForecasts(forecasts)
    }
}