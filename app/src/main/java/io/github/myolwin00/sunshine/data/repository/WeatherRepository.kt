package io.github.myolwin00.sunshine.data.repository

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.content.Context
import android.util.Log
import io.github.myolwin00.sunshine.BuildConfig
import io.github.myolwin00.sunshine.data.Forecast
import io.github.myolwin00.sunshine.data.ForecastResponse
import io.github.myolwin00.sunshine.data.source.local.ForecastDB
import io.github.myolwin00.sunshine.data.source.local.ForecastDao
import io.github.myolwin00.sunshine.data.source.remote.WeatherService
import io.github.myolwin00.sunshine.utils.AppConst
import io.github.myolwin00.sunshine.utils.RetrofitUtil
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by myolwin00 on 11/11/17.
 */
class WeatherRepository private constructor() {

    private val weatherService: WeatherService
    private val forecastsCache: MutableLiveData<List<Forecast>> = MutableLiveData()
    private lateinit var forecastDao: ForecastDao

    companion object {
        val instance: WeatherRepository by lazy {
            WeatherRepository()
        }
    }

    init {
        val retrofit = RetrofitUtil.instance.getRetrofitInstance()
        weatherService = retrofit.create(WeatherService::class.java)
    }

    fun setDb(db: ForecastDB) {
        forecastDao = db.forecastDao
    }

    fun getForecasts(): LiveData<List<Forecast>> {

        return forecastDao.getForecast()

        /*if(forecastsCache.value != null) {
            return forecastsCache
        }

        val liveForecasts: MutableLiveData<List<Forecast>> = MutableLiveData()
        weatherService.getForecasts(AppConst.RANGOON_ID, BuildConfig.WeatherApiKey)
                .enqueue(object: Callback<ForecastResponse> {
                    override fun onResponse(call: Call<ForecastResponse>,
                                            response: Response<ForecastResponse>) {
                        liveForecasts.value = response.body()?.mForecast
                        forecastsCache.value = response.body()?.mForecast

                        val savedCount = forecastDao.save(response.body()?.mForecast)
                        Log.d("SunshineApp", "saved: " + savedCount.size)
                    }
                    override fun onFailure(call: Call<ForecastResponse>?, t: Throwable?) {

                    }
        })

        return liveForecasts*/
    }
}