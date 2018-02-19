package io.github.myolwin00.sunshine.data.source.remote

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.util.Log
import io.github.myolwin00.sunshine.BuildConfig
import io.github.myolwin00.sunshine.data.Forecast
import io.github.myolwin00.sunshine.data.ForecastResponse
import io.github.myolwin00.sunshine.data.repository.WeatherRepository
import io.github.myolwin00.sunshine.utils.AppConst
import io.reactivex.Single
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

/**
 * Created by myolwin00 on 11/13/17.
 */
class WeatherRemoteSource(retrofit: Retrofit) {

    private val weatherService: WeatherService = retrofit.create(WeatherService::class.java)

    fun getForecasts(): Single<ForecastResponse> {
        return weatherService.getForecasts(
                AppConst.RANGOON_ID,
                AppConst.TEMP_UNIT,
                BuildConfig.WeatherApiKey)
    }
}