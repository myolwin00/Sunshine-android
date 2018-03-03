package io.github.myolwin00.sunshine.data.source.local

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import io.github.myolwin00.sunshine.data.Forecast
import io.github.myolwin00.sunshine.data.Weather

/**
 * Created by myolwin00 on 11/11/17.
 */
@Database(entities = arrayOf(Forecast::class), version = 1, exportSchema = false)
abstract class WeatherDB : RoomDatabase() {

    abstract val forecastDao: ForecastDao

    companion object {
        fun getImWeatherDb(context: Context): WeatherDB {
            return Room
                    .inMemoryDatabaseBuilder(context, WeatherDB::class.java)
                    .allowMainThreadQueries()
                    .build()
        }

        fun getWeatherDb(context: Context): WeatherDB {
            return Room
                    .databaseBuilder(context.applicationContext,
                            WeatherDB::class.java, "weather_db")
                    .allowMainThreadQueries()
                    .build()
        }
    }
}