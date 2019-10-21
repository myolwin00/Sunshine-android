package io.github.myolwin00.sunshine.app.di

import dagger.Component
import io.github.myolwin00.sunshine.app.SunshineApp
import io.github.myolwin00.sunshine.app.HomeActivity
import io.github.myolwin00.sunshine.app.forecasts.ForecastsFragment
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, DataModule::class])
interface AppComponent {

    fun inject(app: SunshineApp)
    fun inject(homeActivity: HomeActivity)
    fun inject(fragment: ForecastsFragment)
}
