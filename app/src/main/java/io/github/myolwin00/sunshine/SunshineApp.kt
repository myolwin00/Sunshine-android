package io.github.myolwin00.sunshine

import android.app.Application
import io.github.myolwin00.sunshine.di.AppComponent
import io.github.myolwin00.sunshine.di.AppModule

/**
 * Created by myolwin00 on 11/11/17.
 */
class SunshineApp : Application() {

    /*private val appComponent: AppComponent by lazy {
        DaggerAppComponent.builder().appModule(AppModule(this)).build()
    }*/

    override fun onCreate() {
        super.onCreate()

        //appComponent.inject(this)
    }

    // appComponent(): AppComponent = appComponent
}