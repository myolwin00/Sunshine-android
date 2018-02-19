package io.github.myolwin00.sunshine.data.viewmodel;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.NonNull;

import io.github.myolwin00.sunshine.data.repository.WeatherRepository;
import io.github.myolwin00.sunshine.view.holders.ForecastVH;

/**
 * Created by emrys on 2/19/18.
 */

public class WeatherViewModelFactory implements ViewModelProvider.Factory {

    private WeatherRepository mRepository;

    public WeatherViewModelFactory(WeatherRepository repository) {
        mRepository = repository;
    }

    @NonNull
    @Override
    public ForecastVM create(@NonNull Class modelClass) {
        return new ForecastVM(mRepository);
    }
}
