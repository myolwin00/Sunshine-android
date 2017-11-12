package io.github.myolwin00.sunshine.data.source.local

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import io.github.myolwin00.sunshine.data.Forecast

/**
 * Created by myolwin00 on 11/11/17.
 */
@Database(entities = arrayOf(Forecast::class), version = 1)
abstract class ForecastDB : RoomDatabase() {

    abstract val forecastDao: ForecastDao

    companion object {
        fun getImForecastDb(context: Context): ForecastDB {
            return Room
                    .inMemoryDatabaseBuilder(context, ForecastDB::class.java)
                    .allowMainThreadQueries()
                    .build()
        }

        fun getForecastDb(context: Context): ForecastDB {
            return Room
                    .databaseBuilder(context.applicationContext,
                            ForecastDB::class.java, "sunshine")
                    .allowMainThreadQueries()
                    .build()
        }
    }
}