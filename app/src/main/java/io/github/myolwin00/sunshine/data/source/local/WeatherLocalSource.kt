package io.github.myolwin00.sunshine.data.source.local

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.distinctUntilChanged
import androidx.lifecycle.map
import io.github.myolwin00.sunshine.data.ForecastEntity
import io.github.myolwin00.sunshine.data.dao.ForecastDao
import io.github.myolwin00.sunshine.data.mapper.toDomain
import io.github.myolwin00.sunshine.data.mapper.toEntity
import io.github.myolwin00.sunshine.data.model.Forecast
import javax.inject.Inject

/**
 * Created by myolwin00 on 11/13/17.
 */
class WeatherLocalSource @Inject constructor(private val forecastDao: ForecastDao) {

    fun observeForecasts(): LiveData<List<Forecast>> {
        return forecastDao.observeForecasts()
                .distinctUntilChanged()
                .map { it.toDomain() }
    }

    fun saveForecasts(forecasts: List<Forecast>) {
        forecastDao.insertForecasts(forecasts.toEntity())
    }
}