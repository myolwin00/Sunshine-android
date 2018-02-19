package io.github.myolwin00.sunshine.data.source.remote

import io.github.myolwin00.sunshine.data.Forecast
import io.github.myolwin00.sunshine.data.ForecastResponse
import io.reactivex.Single
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by myolwin00 on 11/11/17.
 */
interface WeatherService {

    //forecast?id=1298824&appid=62c7ea7ffab18d6c20f213bf8bafdd78
    @GET("data/2.5/forecast")
    fun getForecasts (
            @Query("id") cityId: String,
            @Query("units") unit: String,
            @Query("appid") apiKey: String
    ) : Single<ForecastResponse>
}