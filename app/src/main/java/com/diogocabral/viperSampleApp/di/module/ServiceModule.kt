package com.diogocabral.viperSampleApp.di.module

import com.diogocabral.viperSampleApp.interactor.service.PhrasesService
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_PHRASES_URL: String = "http://api.icndb.com/jokes/"

@Module
class ServiceModule {
    @Provides
    fun providesPhrasesService(): PhrasesService = Retrofit.Builder()
            .baseUrl(BASE_PHRASES_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(PhrasesService::class.java)
}