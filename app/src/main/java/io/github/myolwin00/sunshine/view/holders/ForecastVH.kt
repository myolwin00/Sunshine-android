package io.github.myolwin00.sunshine.view.holders

import android.support.v7.widget.RecyclerView
import android.view.View
import io.github.myolwin00.sunshine.data.Forecast
import io.github.myolwin00.sunshine.utils.DateFormatUtil
import io.github.myolwin00.sunshine.utils.TemperatureUtil
import kotlinx.android.synthetic.main.item_forecast.view.*

/**
 * Created by myolwin00 on 11/9/17.
 */
class ForecastVH(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private lateinit var mForecast: Forecast

    fun bind(forecast: Forecast) {
        mForecast = forecast

        itemView.tv_date.text = DateFormatUtil.formatDate(mForecast.mDt)
        itemView.tv_high_temperature.text = TemperatureUtil.formatTemperature(
                itemView.context, forecast.mMain?.mTempMax)
        itemView.tv_low_temperature.text = TemperatureUtil.formatTemperature(
                itemView.context, forecast.mMain?.mTempMin)
    }
}