package io.github.myolwin00.sunshine.data.repository

import androidx.lifecycle.LiveData
import io.github.myolwin00.sunshine.data.Result
import io.github.myolwin00.sunshine.data.model.Forecast
import io.github.myolwin00.sunshine.data.source.local.WeatherLocalSource
import io.github.myolwin00.sunshine.data.source.remote.WeatherRemoteSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject


/**
 * Created by myolwin00 on 11/11/17.
 */
class WeatherRepository @Inject constructor(
        private val weatherRemoteSource: WeatherRemoteSource,
        private val weatherLocalSource: WeatherLocalSource
) {

    suspend fun fetchForecasts(): Result<List<Forecast>> {
        return withContext(Dispatchers.IO) {
            weatherRemoteSource.getForecasts().also {
                if (it is Result.Success) {
                    weatherLocalSource.saveForecasts(it.data)
                }
            }
        }
    }

    fun observeForecasts(): LiveData<List<Forecast>> = weatherLocalSource.observeForecasts()
}