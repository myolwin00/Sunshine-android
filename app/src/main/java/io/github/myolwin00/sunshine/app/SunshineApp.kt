package io.github.myolwin00.sunshine.app

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import io.github.myolwin00.sunshine.BuildConfig
import io.github.myolwin00.sunshine.app.di.DaggerAppComponent
import timber.log.Timber

/**
 * Created by myolwin00 on 11/11/17.
 */
// todo: rename forecast and weather to sync
class SunshineApp : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.factory().create(applicationContext)
    }

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}