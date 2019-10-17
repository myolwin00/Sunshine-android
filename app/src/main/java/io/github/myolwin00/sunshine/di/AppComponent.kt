package io.github.myolwin00.sunshine.di

import dagger.Component
import io.github.myolwin00.sunshine.SunshineApp
import io.github.myolwin00.sunshine.HomeActivity
import io.github.myolwin00.sunshine.forecasts.ForecastsFragment
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AppModule::class, RepoModule::class, DaoModule::class,
        RetrofitModule::class, SourceModule::class, ViewModelModule::class))
interface AppComponent {

    fun inject(app: SunshineApp)
    fun inject(homeActivity: HomeActivity)
    fun inject(fragment: ForecastsFragment)
}
