package io.github.myolwin00.sunshine.app.forecasts

import androidx.annotation.NonNull
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.github.myolwin00.sunshine.data.model.Forecast
import io.github.myolwin00.sunshine.databinding.ItemForecastBinding

/**
 * Created by myolwin00 on 11/9/17.
 */
class ForecastsAdapter : ListAdapter<Forecast, ForecastsAdapter.ForecastViewHolder>(ForecastDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ForecastViewHolder {
        return LayoutInflater.from(parent.context)
                .let {
                    ItemForecastBinding.inflate(it, parent, false)
                }.let {
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
            binding.executePendingBindings()
        }
    }

    object ForecastDiffCallback : DiffUtil.ItemCallback<Forecast>() {
        override fun areItemsTheSame(
                @NonNull old: Forecast, @NonNull new: Forecast): Boolean {
            return old.dt == new.dt
        }

        override fun areContentsTheSame(
                @NonNull old: Forecast, @NonNull new: Forecast): Boolean {
            return old == new
        }
    }
}