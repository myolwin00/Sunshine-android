package io.github.myolwin00.sunshine.data.repository

import androidx.lifecycle.LiveData
import io.github.myolwin00.sunshine.data.Forecast
import io.github.myolwin00.sunshine.data.source.local.WeatherLocalSource
import io.github.myolwin00.sunshine.data.source.remote.WeatherRemoteSource


/**
 * Created by myolwin00 on 11/11/17.
 */
class WeatherRepository(
        private val weatherRemoteSource: WeatherRemoteSource,
        private val weatherLocalSource: WeatherLocalSource
) {

    fun getForecasts(): LiveData<List<Forecast>> {
        TODO("getForecasts")
//        mWeatherRemoteSource.getForecasts()
//                .subscribeOn(Schedulers.io())
//                .toObservable()
//                .map { response -> response.mForecast }
//                .subscribe(
//                        {forecasts -> mWeatherLocalSource.saveForecasts(forecasts)},
//                        {t -> Timber.e("error: %s", t.message)}
//                )


//        return mWeatherLocalSource.getForecasts()
    }
}