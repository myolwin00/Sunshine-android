package io.github.myolwin00.sunshine.data.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import io.github.myolwin00.sunshine.data.Forecast
import io.github.myolwin00.sunshine.data.repository.WeatherRepository
import javax.inject.Inject

/**
 * Created by myolwin00 on 11/10/17.
 */
class ForecastVM @Inject constructor(private val mWeatherRepo: WeatherRepository): ViewModel() {

    val liveForecasts: LiveData<List<Forecast>>

    init {
        liveForecasts = mWeatherRepo.getForecasts()
    }
}