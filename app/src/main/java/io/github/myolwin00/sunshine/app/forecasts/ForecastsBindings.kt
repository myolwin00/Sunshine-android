package io.github.myolwin00.sunshine.app.forecasts

import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import io.github.myolwin00.sunshine.data.model.Forecast

@BindingAdapter("items")
fun setItems(listView: RecyclerView, items: List<Forecast>?) {
    (listView.adapter as ForecastsAdapter).submitList(items)
}

@BindingAdapter("android:src")
fun setImageResource(imageView: ImageView, @DrawableRes res: Int) {
    imageView.setImageResource(res)
}