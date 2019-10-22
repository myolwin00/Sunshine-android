package io.github.myolwin00.sunshine.app.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap
import io.github.myolwin00.sunshine.app.forecasts.ForecastsFragment
import io.github.myolwin00.sunshine.app.forecasts.ForecastsViewModel

@Module
abstract class ForecastsModule {

    @ContributesAndroidInjector(modules = [ViewModelBuilder::class])
    internal abstract fun forecastsFragment(): ForecastsFragment

    @Binds
    @IntoMap
    @ViewModelKey(ForecastsViewModel::class)
    abstract fun bindViewModel(viewmodel: ForecastsViewModel): ViewModel
}