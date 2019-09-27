package io.github.myolwin00.sunshine.data.source.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import io.github.myolwin00.sunshine.data.Forecast

/**
 * Created by myolwin00 on 11/11/17.
 */
@Dao
interface ForecastDao {

    @Insert(onConflict = REPLACE)
    fun saveForecasts(forecasts: List<Forecast>?): Array<Long>

    @Query("SELECT * FROM forecasts")
    fun getForecasts(): LiveData<List<Forecast>>
}