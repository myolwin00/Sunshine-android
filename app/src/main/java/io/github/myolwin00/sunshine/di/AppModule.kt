package io.github.myolwin00.sunshine.di

import android.content.Context
import dagger.Module
import dagger.Provides
import io.github.myolwin00.sunshine.SunshineApp

@Module
class AppModule(private val app: SunshineApp) {

    @Provides
    fun provideApp(): SunshineApp = app

    @Provides
    fun provideContext(): Context = app
}