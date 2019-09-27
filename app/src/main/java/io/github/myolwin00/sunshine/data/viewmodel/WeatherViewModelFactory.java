package io.github.myolwin00.sunshine.data.viewmodel;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProvider;

import io.github.myolwin00.sunshine.data.repository.WeatherRepository;

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
