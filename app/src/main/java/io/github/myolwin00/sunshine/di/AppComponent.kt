package io.github.myolwin00.sunshine.di

import dagger.Component
import io.github.myolwin00.sunshine.SunshineApp
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AppModule::class))
interface AppComponent {

    fun inject(app: SunshineApp)
}
