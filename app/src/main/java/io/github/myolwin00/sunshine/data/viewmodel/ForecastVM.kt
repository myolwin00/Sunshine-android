package io.github.myolwin00.sunshine.data.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import android.content.Context
import io.github.myolwin00.sunshine.data.Forecast
import io.github.myolwin00.sunshine.data.repository.WeatherRepository
import io.github.myolwin00.sunshine.data.source.local.ForecastDB
import javax.inject.Inject

/**
 * Created by myolwin00 on 11/10/17.
 */
class ForecastVM : ViewModel(){

    lateinit var liveForecasts: LiveData<List<Forecast>>

    fun initialize(weatherRepo: WeatherRepository) {
        liveForecasts = weatherRepo.getForecasts()
    }
}