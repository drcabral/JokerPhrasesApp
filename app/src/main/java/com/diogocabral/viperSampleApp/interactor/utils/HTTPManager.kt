package com.diogocabral.viperSampleApp.interactor.utils

import com.diogocabral.viperSampleApp.interactor.service.PhrasesService
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_PHRASES_URL: String = "http://api.icndb.com/jokes/"

object HTTPManager {
    val phrasesService by lazy { createPhraseService() }

    private fun createPhraseService(): PhrasesService {
        val gson = GsonBuilder()
                .setLenient()
                .create()

        val retrofit = Retrofit.Builder()
                .baseUrl(BASE_PHRASES_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()

        return retrofit.create(PhrasesService::class.java)
    }
}