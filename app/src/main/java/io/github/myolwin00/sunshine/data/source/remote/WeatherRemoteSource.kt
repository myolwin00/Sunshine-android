package io.github.myolwin00.sunshine.data.source.remote

import io.github.myolwin00.sunshine.BuildConfig
import io.github.myolwin00.sunshine.data.mapper.toDomain
import io.github.myolwin00.sunshine.data.network.ForecastService
import io.github.myolwin00.sunshine.app.utils.AppConst
import io.github.myolwin00.sunshine.data.Result
import io.github.myolwin00.sunshine.data.model.Forecast
import javax.inject.Inject

/**
 * Created by myolwin00 on 11/13/17.
 */
class WeatherRemoteSource @Inject constructor(private val forecastService: ForecastService) {

    suspend fun getForecasts(): Result<List<Forecast>> {
        return try {
            forecastService.getForecasts(
                    AppConst.RANGOON_ID,
                    AppConst.TEMP_UNIT,
                    BuildConfig.WeatherApiKey
            ).list.toDomain().let {
                Result.Success(it)
            }
        } catch (e: Exception) {
            Result.Error(e)
        }
    }
}