package io.github.myolwin00.sunshine.view.holders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import io.github.myolwin00.sunshine.data.Forecast
import kotlinx.android.synthetic.main.item_forecast.view.*

/**
 * Created by myolwin00 on 11/9/17.
 */
class ForecastVH(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val tvDate = itemView.tv_date
    private val tvHighTemp = itemView.tv_high_temperature
    private val tvLowTemp = itemView.tv_low_temperature
    private val tvWeatherDesc = itemView.tv_weather_desc
    private val ivWeatherIcon = itemView.iv_weather_icon

    private lateinit var mForecast: Forecast

    fun bind(forecast: Forecast) {
        mForecast = forecast

        ivWeatherIcon.setImageResource(forecast.getWeatherIcon())
        tvDate.text = forecast.getReadableDate()
        tvHighTemp.text = forecast.getHighTemp(itemView.context)
        tvLowTemp.text = forecast.getLowTemp(itemView.context)
        tvWeatherDesc.text = forecast.getWeatherDesc()
    }
}