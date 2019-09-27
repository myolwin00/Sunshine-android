package io.github.myolwin00.sunshine.data


data class ForecastResponse(
        var mCnt: Long,
        var mCod: String,
        var mForecast: List<Forecast>,
        var mMessage: Double
)