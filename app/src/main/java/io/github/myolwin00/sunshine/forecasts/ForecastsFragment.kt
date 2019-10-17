package io.github.myolwin00.sunshine.forecasts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import io.github.myolwin00.sunshine.SunshineApp
import io.github.myolwin00.sunshine.databinding.FragmentForecastsBinding
import javax.inject.Inject

class ForecastsFragment: Fragment() {

    @Inject
    lateinit var viewModelFactory: ForecastViewModel.WeatherViewModelFactory
    private val forecastViewModel: ForecastViewModel by viewModels { viewModelFactory }
    private lateinit var forecastAdapter: ForecastAdapter
    private lateinit var binding: FragmentForecastsBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentForecastsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (context?.applicationContext as SunshineApp).appComponent.inject(this)

        forecastAdapter = ForecastAdapter()
        binding.rvForecasts.adapter = forecastAdapter

        forecastViewModel.forecasts.observe(this) { forecasts ->
            forecastAdapter.submitList(forecasts)
        }
    }
}