package io.github.myolwin00.sunshine.activities

import android.os.Bundle
import android.view.View.GONE
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import io.github.myolwin00.sunshine.R
import io.github.myolwin00.sunshine.SunshineApp
import io.github.myolwin00.sunshine.adapters.ForecastAdapter
import io.github.myolwin00.sunshine.data.viewmodel.ForecastVM
import io.github.myolwin00.sunshine.data.viewmodel.WeatherViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: WeatherViewModelFactory
    private val forecastViewModel: ForecastVM by viewModels { viewModelFactory }
    private lateinit var forecastAdapter: ForecastAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (applicationContext as SunshineApp).appComponent.inject(this)

        setupRecyclerView()

        observeForecast()
    }

    private fun setupRecyclerView() {
        forecastAdapter = ForecastAdapter()
        rv_forecasts.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            addItemDecoration(DividerItemDecoration(this@MainActivity, DividerItemDecoration.VERTICAL))
            adapter = forecastAdapter
        }
    }

    private fun observeForecast() {
        forecastViewModel.liveForecasts.observe(this) { forecasts ->
            forecastAdapter.submitList(forecasts)
            pb_loading.visibility = GONE
        }
    }
}
