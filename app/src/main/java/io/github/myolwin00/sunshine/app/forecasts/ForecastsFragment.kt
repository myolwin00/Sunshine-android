package io.github.myolwin00.sunshine.app.forecasts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import dagger.android.support.DaggerFragment
import io.github.myolwin00.sunshine.app.SunshineApp
import io.github.myolwin00.sunshine.databinding.FragmentForecastsBinding
import timber.log.Timber
import javax.inject.Inject

class ForecastsFragment : DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val forecastsViewModel: ForecastsViewModel by viewModels { viewModelFactory }
    private lateinit var binding: FragmentForecastsBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return FragmentForecastsBinding.inflate(inflater, container, false)
                .also { binding = it }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = ForecastsAdapter()
        binding.apply {
            lifecycleOwner = viewLifecycleOwner
            viewModel = forecastsViewModel
            rvForecasts.adapter = adapter
        }
    }
}