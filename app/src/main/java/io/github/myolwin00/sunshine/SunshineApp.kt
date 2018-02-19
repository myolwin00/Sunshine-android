package io.github.myolwin00.sunshine

import android.app.Application
import android.os.Debug
import io.github.myolwin00.sunshine.di.AppComponent
import io.github.myolwin00.sunshine.di.AppModule
import io.github.myolwin00.sunshine.di.DaggerAppComponent
import timber.log.Timber

/**
 * Created by myolwin00 on 11/11/17.
 */
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

    fun appComponent(): AppComponent = appComponent
}