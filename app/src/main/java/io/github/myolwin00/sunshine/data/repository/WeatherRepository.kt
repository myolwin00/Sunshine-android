package io.github.myolwin00.sunshine.data.repository

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import io.github.myolwin00.sunshine.data.Forecast
import io.github.myolwin00.sunshine.data.source.local.WeatherLocalSource
import io.github.myolwin00.sunshine.data.source.remote.WeatherRemoteSource



/**
 * Created by myolwin00 on 11/11/17.
 */
class WeatherRepository(weatherRemoteSource: WeatherRemoteSource, weatherLocalSource: WeatherLocalSource) {

    private val mWeatherRemoteSource: WeatherRemoteSource = weatherRemoteSource
    private val mWeatherLocalSource: WeatherLocalSource = weatherLocalSource

    var mCachedForecasts: MutableLiveData<List<Forecast>> = MutableLiveData()
    var hasCache = false

    fun getForecasts(): LiveData<List<Forecast>> {

        if (!hasCache) {
            val offlineForecasts = mWeatherLocalSource.getForecasts()
            if (offlineForecasts != null && offlineForecasts.size > 0) {
                refreshCache(offlineForecasts)
            } else {
                mWeatherRemoteSource.getForecasts(object: LoadForecastsCallback {
                    override fun onLoaded(forecasts: List<Forecast>?) {
                        if (forecasts != null) {
                            refreshCache(forecasts)
                            refreshLocalSource(forecasts)
                        }
                    }
                    override fun onFailed() {
                    }
                })
            }
        }
        return mCachedForecasts
    }

    private fun refreshCache(forecasts: List<Forecast>) {
        hasCache = true
        mCachedForecasts.value = forecasts
    }

    private fun refreshLocalSource(forecasts: List<Forecast>) {
        mWeatherLocalSource.saveForecasts(forecasts)
    }

    interface LoadForecastsCallback {
        fun onLoaded(forecasts: List<Forecast>?)
        fun onFailed()
    }
}