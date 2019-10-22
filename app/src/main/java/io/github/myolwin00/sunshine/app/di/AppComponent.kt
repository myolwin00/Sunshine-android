package io.github.myolwin00.sunshine.app.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import io.github.myolwin00.sunshine.app.SunshineApp
import io.github.myolwin00.sunshine.app.HomeActivity
import io.github.myolwin00.sunshine.app.forecasts.ForecastsFragment
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidInjectionModule::class, DataModule::class, ForecastsModule::class
])
interface AppComponent : AndroidInjector<SunshineApp> {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance applicationContext: Context): AppComponent
    }
}
