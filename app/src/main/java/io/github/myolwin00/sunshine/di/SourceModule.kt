package io.github.myolwin00.sunshine.di

import dagger.Module
import dagger.Provides
import io.github.myolwin00.sunshine.data.source.local.ForecastDao
import io.github.myolwin00.sunshine.data.source.local.WeatherLocalSource
import io.github.myolwin00.sunshine.data.source.remote.WeatherRemoteSource
import retrofit2.Retrofit
import javax.inject.Singleton

/**
 * Created by myolwin00 on 11/13/17.
 */
@Module
class SourceModule {

    @Provides
    @Singleton
    fun provideWeatherLocalSource(forecastDao: ForecastDao): WeatherLocalSource {
        return WeatherLocalSource(forecastDao)
    }

    @Provides
    @Singleton
    fun provideWeatherRemoteSource(retrofit: Retrofit): WeatherRemoteSource {
        return WeatherRemoteSource(retrofit)
    }
}