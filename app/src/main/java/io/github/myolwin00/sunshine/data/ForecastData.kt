package io.github.myolwin00.sunshine.data

import com.squareup.moshi.Json

data class ForecastResponse(
        val city: City,
        val cnt: Int,
        val cod: String,
        val list: List<ForecastData>,
        val message: Double
)

data class City(
        val coord: Coord,
        val country: String,
        val id: Int,
        val name: String,
        val sunrise: Int,
        val sunset: Int,
        val timezone: Int
)

data class ForecastData(
        val dt: Long,
        @field:Json(name = "dt_txt")
        val dtTxt: String,
        val main: Main,
        val weather: List<Weather>,
        val wind: Wind
)

data class Main(
        @field:Json(name = "grnd_level")
        var grndLevel: Double,
        val humidity: Int,
        val pressure: Double,
        @field:Json(name = "sea_level")
        val seaLevel: Double,
        val temp: Double,
        @field:Json(name = "temp_kf")
        val tempKf: Float,
        @field:Json(name = "temp_max")
        val tempMax: Float,
        @field:Json(name = "temp_min")
        val tempMin: Float
)

data class Wind(
        val deg: Double,
        val speed: Double
)

data class Weather(
        val description: String,
        val icon: String,
        val id: Int,
        val main: String
)

data class Coord(
        val lat: Double,
        val lon: Double
)