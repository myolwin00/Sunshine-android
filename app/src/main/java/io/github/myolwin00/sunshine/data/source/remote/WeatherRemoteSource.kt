package io.github.myolwin00.sunshine.data.source.remote

import io.github.myolwin00.sunshine.BuildConfig
import io.github.myolwin00.sunshine.data.ForecastResponse
import io.github.myolwin00.sunshine.utils.AppConst
import retrofit2.Retrofit

/**
 * Created by myolwin00 on 11/13/17.
 */
class WeatherRemoteSource(retrofit: Retrofit) {

    private val weatherService: WeatherService = retrofit.create(WeatherService::class.java)

    fun getForecasts(): ForecastResponse {
        return weatherService.getForecasts(
                AppConst.RANGOON_ID,
                AppConst.TEMP_UNIT,
                BuildConfig.WeatherApiKey)
    }
}