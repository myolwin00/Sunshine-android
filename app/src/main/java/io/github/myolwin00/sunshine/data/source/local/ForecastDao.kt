package io.github.myolwin00.sunshine.data.source.local

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy.REPLACE
import android.arch.persistence.room.Query
import io.github.myolwin00.sunshine.data.Forecast

/**
 * Created by myolwin00 on 11/11/17.
 */
@Dao
interface ForecastDao {

    @Insert(onConflict = REPLACE)
    fun save(forecasts: List<Forecast>?): Array<Long>

    @Query("SELECT * FROM forecasts")
    fun getForecast(): LiveData<List<Forecast>>
}