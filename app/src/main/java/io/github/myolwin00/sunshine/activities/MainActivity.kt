package io.github.myolwin00.sunshine.activities

import android.os.Bundle
import android.view.View.GONE
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
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

    private lateinit var mForecastVM: ForecastVM
    private lateinit var mForecastAdapter: ForecastAdapter

    @Inject lateinit var mViewModelFactory: WeatherViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (applicationContext as SunshineApp).appComponent.inject(this)

        mForecastVM = ViewModelProvider(this, mViewModelFactory).get(ForecastVM::class.java)

        setupRecyclerView()

        observeForecast()
    }

    private fun setupRecyclerView() {
        mForecastAdapter = ForecastAdapter()
        rv_forecasts.layoutManager = LinearLayoutManager(this)
        rv_forecasts.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        rv_forecasts.adapter = mForecastAdapter
    }

    private fun observeForecast() {
        mForecastVM.liveForecasts.observe(this, Observer {
            forecasts -> mForecastAdapter.submitList(forecasts)
            pb_loading.visibility = GONE
        })
    }
}
