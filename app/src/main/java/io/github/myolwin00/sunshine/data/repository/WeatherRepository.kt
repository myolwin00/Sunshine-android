package io.github.myolwin00.sunshine.data.repository

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import io.github.myolwin00.sunshine.data.Forecast
import io.github.myolwin00.sunshine.data.source.local.WeatherLocalSource
import io.github.myolwin00.sunshine.data.source.remote.WeatherRemoteSource
import io.reactivex.functions.BiConsumer
import io.reactivex.functions.Predicate
import io.reactivex.schedulers.Schedulers
import timber.log.Timber


/**
 * Created by myolwin00 on 11/11/17.
 */
class WeatherRepository(weatherRemoteSource: WeatherRemoteSource, weatherLocalSource: WeatherLocalSource) {

    private val mWeatherRemoteSource: WeatherRemoteSource = weatherRemoteSource
    private val mWeatherLocalSource: WeatherLocalSource = weatherLocalSource

    fun getForecasts(): LiveData<List<Forecast>> {
        mWeatherRemoteSource.getForecasts()
                .subscribeOn(Schedulers.io())
                .map({ response -> response.mForecast })
                .subscribe(
                        {forecasts -> mWeatherLocalSource.saveForecasts(forecasts)},
                        {t -> Timber.e("error: %s", t.message)}
                )


        return mWeatherLocalSource.getForecasts()
    }
}