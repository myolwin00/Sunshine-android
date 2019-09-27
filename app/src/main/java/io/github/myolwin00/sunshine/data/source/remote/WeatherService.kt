package io.github.myolwin00.sunshine.data.source.remote

import io.github.myolwin00.sunshine.data.ForecastResponse
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by myolwin00 on 11/11/17.
 */
interface WeatherService {

    @GET("data/2.5/forecast")
    fun getForecasts (
            @Query("id") cityId: String,
            @Query("units") unit: String,
            @Query("appid") apiKey: String
    ) : ForecastResponse
}