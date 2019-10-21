package io.github.myolwin00.sunshine.app

import android.app.Application
import io.github.myolwin00.sunshine.BuildConfig
import io.github.myolwin00.sunshine.app.di.AppComponent
import io.github.myolwin00.sunshine.app.di.AppModule
import io.github.myolwin00.sunshine.app.di.DaggerAppComponent
import timber.log.Timber

/**
 * Created by myolwin00 on 11/11/17.
 */
// todo: rename forecast and weather to sync
class SunshineApp : Application() {

    val appComponent: AppComponent by lazy {
        DaggerAppComponent.builder().appModule(AppModule(this)).build()
    }

    override fun onCreate() {
        super.onCreate()

        appComponent.inject(this)

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}