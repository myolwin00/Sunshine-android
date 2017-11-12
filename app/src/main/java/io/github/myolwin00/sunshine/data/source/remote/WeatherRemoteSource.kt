package io.github.myolwin00.sunshine.data.source.remote

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.util.Log
import io.github.myolwin00.sunshine.BuildConfig
import io.github.myolwin00.sunshine.data.Forecast
import io.github.myolwin00.sunshine.data.ForecastResponse
import io.github.myolwin00.sunshine.data.repository.WeatherRepository
import io.github.myolwin00.sunshine.utils.AppConst
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

/**
 * Created by myolwin00 on 11/13/17.
 */
class WeatherRemoteSource(retrofit: Retrofit) {

    private val weatherService: WeatherService = retrofit.create(WeatherService::class.java)

    fun getForecasts(callback: WeatherRepository.LoadForecastsCallback) {
        weatherService.getForecasts(AppConst.RANGOON_ID, AppConst.TEMP_UNIT, BuildConfig.WeatherApiKey)
                .enqueue(object: Callback<ForecastResponse> {
                    override fun onResponse(call: Call<ForecastResponse>,
                                            response: Response<ForecastResponse>) {
                        callback.onLoaded(response.body()?.mForecast)
                    }
                    override fun onFailure(call: Call<ForecastResponse>?, t: Throwable?) {
                        callback.onFailed()
                    }
                })
    }
}