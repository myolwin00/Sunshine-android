package io.github.myolwin00.sunshine.activities

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import io.github.myolwin00.sunshine.R
import io.github.myolwin00.sunshine.adapters.ForecastAdapter
import io.github.myolwin00.sunshine.data.source.local.ForecastDB
import io.github.myolwin00.sunshine.data.viewmodel.ForecastVM
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var mForecastVM: ForecastVM
    private lateinit var mForecastAdapter: ForecastAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mForecastVM = ViewModelProviders.of(this).get(ForecastVM::class.java)
        val db: ForecastDB = ForecastDB.getForecastDb(this)
        mForecastVM.initialize(db)

        setupRecyclerView()

        observeForecast()
    }

    private fun setupRecyclerView() {
        mForecastAdapter = ForecastAdapter()
        rv_forecasts.layoutManager = LinearLayoutManager(this)
        rv_forecasts.adapter = mForecastAdapter
    }

    private fun observeForecast() {
        mForecastVM.liveForecasts?.observe(this, Observer {
            forecasts -> mForecastAdapter.replaceData(forecasts!!)
        })
    }
}
