package io.github.myolwin00.sunshine.app.forecasts

import androidx.lifecycle.*
import io.github.myolwin00.sunshine.data.Result
import io.github.myolwin00.sunshine.data.model.Forecast
import io.github.myolwin00.sunshine.data.repository.WeatherRepository
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

/**
 * Created by myolwin00 on 11/10/17.
 */
class ForecastsViewModel @Inject constructor(weatherRepository: WeatherRepository) : ViewModel() {

    private val _loading: MutableLiveData<Boolean> = MutableLiveData(false)
    val loading: LiveData<Boolean> = _loading

    private val _forecasts = weatherRepository.observeForecasts()
    val forecasts: LiveData<List<Forecast>> = _forecasts

    init {
        viewModelScope.launch {
            _loading.value = true
            when (weatherRepository.fetchForecasts()) {
                // will handle error case later
                is Result.Success, is Result.Error -> _loading.value = false
            }
        }
    }
}