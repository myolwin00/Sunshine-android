package io.github.myolwin00.sunshine.app.di

import android.content.Context
import dagger.Module
import dagger.Provides
import io.github.myolwin00.sunshine.data.dao.ForecastDao
import io.github.myolwin00.sunshine.data.db.WeatherDB
import io.github.myolwin00.sunshine.data.network.ForecastService
import io.github.myolwin00.sunshine.app.utils.AppConst
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class DataModule {

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
                .baseUrl(AppConst.BASE_API_URL)
                .addConverterFactory(MoshiConverterFactory.create())
                .client(okHttpClient)
                .build()
    }

    @Singleton
    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
                .connectTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(15, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .build()
    }

    @Singleton
    @Provides
    fun provideForecastService(retrofit: Retrofit): ForecastService {
        return retrofit.create(ForecastService::class.java)
    }

    @Provides
    @Singleton
    fun provideWeatherDB(context: Context): WeatherDB {
        return WeatherDB.getWeatherDb(context)
    }

    @Provides
    @Singleton
    fun provideForecastDao(weatherDB: WeatherDB): ForecastDao {
        return weatherDB.forecastDao
    }
}