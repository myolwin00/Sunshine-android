package io.github.myolwin00.sunshine.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import io.github.myolwin00.sunshine.R
import io.github.myolwin00.sunshine.data.Forecast
import io.github.myolwin00.sunshine.view.holders.ForecastVH

/**
 * Created by myolwin00 on 11/9/17.
 */
class ForecastAdapter : RecyclerView.Adapter<ForecastVH>() {

    private var mForecasts: MutableList<Forecast>

    init {
        mForecasts = ArrayList()
    }

    override fun getItemCount(): Int {
        return mForecasts.size
    }

    override fun onBindViewHolder(holder: ForecastVH, position: Int) {
        holder.bind(mForecasts[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ForecastVH {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_forecast, parent, false)
        return ForecastVH(view)
    }

    fun replaceData(forecasts: List<Forecast>) {
        mForecasts.clear()
        mForecasts.addAll(forecasts)
        notifyDataSetChanged()
    }
}