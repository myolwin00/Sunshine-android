package io.github.myolwin00.sunshine.di

import dagger.Component
import io.github.myolwin00.sunshine.SunshineApp
import io.github.myolwin00.sunshine.activities.MainActivity
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AppModule::class, RepoModule::class, DaoModule::class,
        RetrofitModule::class, SourceModule::class))
interface AppComponent {

    fun inject(app: SunshineApp)
    fun inject(mainActivity: MainActivity)
}
