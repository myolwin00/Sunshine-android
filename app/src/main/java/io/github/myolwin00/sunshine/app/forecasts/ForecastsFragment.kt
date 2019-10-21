package io.github.myolwin00.sunshine.app.forecasts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import io.github.myolwin00.sunshine.app.SunshineApp
import io.github.myolwin00.sunshine.databinding.FragmentForecastsBinding
import timber.log.Timber
import javax.inject.Inject

class ForecastsFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ForecastsViewModel.WeatherViewModelFactory
    private val forecastsViewModel: ForecastsViewModel by viewModels { viewModelFactory }
    private lateinit var binding: FragmentForecastsBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return FragmentForecastsBinding.inflate(inflater, container, false)
                .also { binding = it }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (context?.applicationContext as SunshineApp).appComponent.inject(this)

        val adapter = ForecastsAdapter()
        binding.apply {
            lifecycleOwner = viewLifecycleOwner
            viewModel = forecastsViewModel
            rvForecasts.adapter = adapter
        }
    }
}