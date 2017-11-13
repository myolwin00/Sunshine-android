package io.github.myolwin00.sunshine.activities

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View.GONE
import io.github.myolwin00.sunshine.R
import io.github.myolwin00.sunshine.SunshineApp
import io.github.myolwin00.sunshine.adapters.ForecastAdapter
import io.github.myolwin00.sunshine.data.repository.WeatherRepository
import io.github.myolwin00.sunshine.data.viewmodel.ForecastVM
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    private lateinit var mForecastVM: ForecastVM
    private lateinit var mForecastAdapter: ForecastAdapter

    @Inject lateinit var weatherRepo: WeatherRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (applicationContext as SunshineApp).appComponent.inject(this)
        mForecastVM = ViewModelProviders.of(this).get(ForecastVM::class.java)
        mForecastVM.initialize(weatherRepo)

        setupRecyclerView()

        observeForecast()
    }

    private fun setupRecyclerView() {
        mForecastAdapter = ForecastAdapter()
        rv_forecasts.layoutManager = LinearLayoutManager(this)
        rv_forecasts.adapter = mForecastAdapter
    }

    private fun observeForecast() {
        mForecastVM.liveForecasts.observe(this, Observer {
            forecasts -> mForecastAdapter.replaceData(forecasts!!)
            pb_loading.visibility = GONE
        })
    }
}
