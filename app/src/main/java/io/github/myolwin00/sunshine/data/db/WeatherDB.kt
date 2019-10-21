package io.github.myolwin00.sunshine.data.db

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import android.content.Context
import io.github.myolwin00.sunshine.data.ForecastEntity
import io.github.myolwin00.sunshine.data.dao.ForecastDao

/**
 * Created by myolwin00 on 11/11/17.
 */
@Database(entities = [ForecastEntity::class], version = 1, exportSchema = false)
abstract class WeatherDB : RoomDatabase() {

    abstract val forecastDao: ForecastDao

    companion object {
        fun getImWeatherDb(context: Context): WeatherDB {
            return Room.inMemoryDatabaseBuilder(context, WeatherDB::class.java)
                    .allowMainThreadQueries()
                    .build()
        }

        fun getWeatherDb(context: Context): WeatherDB {
            return Room.databaseBuilder(context.applicationContext,
                    WeatherDB::class.java, "weather_db")
                    .allowMainThreadQueries()
                    .build()
        }
    }
}