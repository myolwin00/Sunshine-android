package io.github.myolwin00.sunshine.data.mapper

import io.github.myolwin00.sunshine.data.ForecastData
import io.github.myolwin00.sunshine.data.ForecastEntity
import io.github.myolwin00.sunshine.data.model.Forecast

@JvmName("ForecastDataToDomain")
fun List<ForecastData>.toDomain(): List<Forecast> = map {
    Forecast(
            dt = it.dt,
            weatherId = it.weather.firstOrNull()?.id ?: 0,
            weatherDesc = it.weather.firstOrNull()?.description ?: "",
            tempMax = it.main.tempMax,
            tempMin = it.main.tempMin
    )
}

@JvmName("ForecastEntityToDomain")
fun List<ForecastEntity>.toDomain(): List<Forecast> = map {
    Forecast(
            dt = it.dt,
            weatherId = it.weatherId,
            weatherDesc = it.weatherDesc,
            tempMax = it.tempMax,
            tempMin = it.tempMin
    )
}

@JvmName("ForecastDomainToEntity")
fun List<Forecast>.toEntity(): List<ForecastEntity> = map {
    ForecastEntity(
            dt = it.dt,
            weatherId = it.weatherId,
            weatherDesc = it.weatherDesc,
            tempMax = it.tempMax,
            tempMin = it.tempMin
    )
}