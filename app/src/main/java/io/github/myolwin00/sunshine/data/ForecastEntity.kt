package io.github.myolwin00.sunshine.data

import androidx.room.*

/**
 * Created by myolwin00 on 11/9/17.
 */
@Entity(tableName = "forecasts")
data class ForecastEntity(
        @PrimaryKey
        val dt: Long,
        @ColumnInfo(name = "weather_id")
        val weatherId: Int,
        @ColumnInfo(name = "weather_desc")
        val weatherDesc: String,
        @ColumnInfo(name = "temp_max")
        val tempMax: Float,
        @ColumnInfo(name = "temp_min")
        val tempMin: Float
)