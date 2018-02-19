package io.github.myolwin00.sunshine.di

import dagger.Module
import dagger.Provides
import io.github.myolwin00.sunshine.data.repository.WeatherRepository
import io.github.myolwin00.sunshine.data.source.local.ForecastDao
import io.github.myolwin00.sunshine.data.source.local.WeatherLocalSource
import io.github.myolwin00.sunshine.data.viewmodel.WeatherViewModelFactory
import javax.inject.Singleton

/**
 * Created by emrys on 2/20/18.
 */
@Module
class ViewModelModule {

    @Provides
    @Singleton
    fun provideWeatherViewModelFactory(repository: WeatherRepository): WeatherViewModelFactory {
        return WeatherViewModelFactory(repository)
    }
}