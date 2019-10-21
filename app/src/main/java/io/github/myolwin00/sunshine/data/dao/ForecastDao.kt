package io.github.myolwin00.sunshine.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import io.github.myolwin00.sunshine.data.ForecastEntity

/**
 * Created by myolwin00 on 11/11/17.
 */
@Dao
interface ForecastDao {

    @Insert(onConflict = REPLACE)
    fun insertForecasts(forecasts: List<ForecastEntity>): Array<Long>

    @Query("SELECT * FROM forecasts")
    fun observeForecasts(): LiveData<List<ForecastEntity>>
}