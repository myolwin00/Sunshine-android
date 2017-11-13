package io.github.myolwin00.sunshine.di

import android.content.Context
import dagger.Module
import dagger.Provides
import io.github.myolwin00.sunshine.data.source.local.WeatherDB
import io.github.myolwin00.sunshine.data.source.local.ForecastDao
import javax.inject.Singleton

/**
 * Created by myolwin00 on 11/12/17.
 */
@Module
class DaoModule {

    @Provides
    @Singleton
    fun provideWeatherDB(context: Context): WeatherDB {
        return WeatherDB.getImWeatherDb(context)
    }

    @Provides
    @Singleton
    fun provideForecastDao(weatherDB: WeatherDB): ForecastDao {
        return weatherDB.forecastDao
    }
}