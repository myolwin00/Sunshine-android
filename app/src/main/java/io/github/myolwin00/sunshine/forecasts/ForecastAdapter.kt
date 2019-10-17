package io.github.myolwin00.sunshine.forecasts

import androidx.annotation.NonNull
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.github.myolwin00.sunshine.R
import io.github.myolwin00.sunshine.data.Forecast
import io.github.myolwin00.sunshine.databinding.ItemForecastBinding

/**
 * Created by myolwin00 on 11/9/17.
 */
class ForecastAdapter : ListAdapter<Forecast, ForecastAdapter.ForecastViewHolder>(ForecastDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ForecastViewHolder {
        return LayoutInflater.from(parent.context)
                .let {
                    ItemForecastBinding.inflate(it, parent, false)
                }.let {
                    it.context = parent.context
                    ForecastViewHolder(it)
                }
    }

    override fun onBindViewHolder(holder: ForecastViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ForecastViewHolder(
            private val binding: ItemForecastBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(forecast: Forecast) {
            binding.forecast = forecast
        }
    }

    object ForecastDiffCallback : DiffUtil.ItemCallback<Forecast>() {
        override fun areItemsTheSame(
                @NonNull oldUser: Forecast, @NonNull newUser: Forecast): Boolean {
            return oldUser.mDt === newUser.mDt
        }

        override fun areContentsTheSame(
                @NonNull oldUser: Forecast, @NonNull newUser: Forecast): Boolean {
            return oldUser.mDt == newUser.mDt
        }
    }
}