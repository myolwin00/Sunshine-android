package io.github.myolwin00.sunshine.app.forecasts

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import io.github.myolwin00.sunshine.data.model.Forecast

@BindingAdapter("app:items")
fun setItems(listView: RecyclerView, items: List<Forecast>?) {
    (listView.adapter as ForecastsAdapter).submitList(items)
}