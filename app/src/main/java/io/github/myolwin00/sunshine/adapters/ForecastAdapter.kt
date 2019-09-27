package io.github.myolwin00.sunshine.adapters

import androidx.annotation.NonNull
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import io.github.myolwin00.sunshine.R
import io.github.myolwin00.sunshine.data.Forecast
import io.github.myolwin00.sunshine.view.holders.ForecastVH

/**
 * Created by myolwin00 on 11/9/17.
 */
class ForecastAdapter : ListAdapter<Forecast, ForecastVH>(DIFF_CALLBACK) {

    override fun onBindViewHolder(holder: ForecastVH, position: Int) {
        holder.bind(getItem(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ForecastVH {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_forecast, parent, false)
        return ForecastVH(view)
    }

    companion object {
        val DIFF_CALLBACK: DiffUtil.ItemCallback<Forecast> = object : DiffUtil.ItemCallback<Forecast>() {
            override fun areItemsTheSame(
                    @NonNull oldUser: Forecast, @NonNull newUser: Forecast): Boolean {
                // User properties may have changed if reloaded from the DB, but ID is fixed
                return oldUser.mDt === newUser.mDt
            }

            override fun areContentsTheSame(
                    @NonNull oldUser: Forecast, @NonNull newUser: Forecast): Boolean {
                // NOTE: if you use equals, your object must properly override Object#equals()
                // Incorrectly returning false here will result in too many animations.
                return oldUser == newUser
            }
        }
    }
}