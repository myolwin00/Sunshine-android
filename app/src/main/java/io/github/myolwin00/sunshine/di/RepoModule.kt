package io.github.myolwin00.sunshine.di

import dagger.Module
import dagger.Provides
import io.github.myolwin00.sunshine.data.repository.WeatherRepository
import io.github.myolwin00.sunshine.data.source.local.WeatherLocalSource
import io.github.myolwin00.sunshine.data.source.remote.WeatherRemoteSource
import javax.inject.Singleton

/**
 * Created by myolwin00 on 11/12/17.
 */
@Module
class RepoModule {

    @Provides
    @Singleton
    fun provideWeatherRepo(weatherRemoteSource: WeatherRemoteSource,
                           weatherLocalSource: WeatherLocalSource): WeatherRepository {
        return WeatherRepository(weatherRemoteSource, weatherLocalSource)
    }
}