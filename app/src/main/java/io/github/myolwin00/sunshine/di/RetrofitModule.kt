package io.github.myolwin00.sunshine.di

import dagger.Module
import dagger.Provides
import io.github.myolwin00.sunshine.utils.RetrofitUtil
import retrofit2.Retrofit
import javax.inject.Singleton

/**
 * Created by myolwin00 on 11/12/17.
 */
@Module
class RetrofitModule {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return RetrofitUtil().getRetrofitInstance()
    }
}