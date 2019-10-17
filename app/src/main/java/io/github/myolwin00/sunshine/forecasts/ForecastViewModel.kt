package io.github.myolwin00.sunshine.forecasts

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import io.github.myolwin00.sunshine.data.Forecast
import io.github.myolwin00.sunshine.data.repository.WeatherRepository
import javax.inject.Inject

/**
 * Created by myolwin00 on 11/10/17.
 */
class ForecastViewModel @Inject constructor(weatherRepository: WeatherRepository) : ViewModel() {

    val forecasts: LiveData<List<Forecast>> = weatherRepository.getForecasts()

    class WeatherViewModelFactory @Inject constructor(
            private val weatherRepository: WeatherRepository
    ) : ViewModelProvider.Factory {

        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return ForecastViewModel(weatherRepository) as T
        }

    }
}