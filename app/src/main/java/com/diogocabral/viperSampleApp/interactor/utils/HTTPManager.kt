package com.diogocabral.viperSampleApp.interactor.utils

import com.diogocabral.viperSampleApp.interactor.service.PhrasesService
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class HTTPManager {
    companion object {
        private val BASE_PHRASES_URL : String = "http://api.icndb.com/jokes/"
        lateinit var phrasesAPI : PhrasesService

        fun createPhraseService() {
            val gson = GsonBuilder()
                    .setLenient()
                    .create()

            val retrofit = Retrofit.Builder()
                    .baseUrl(BASE_PHRASES_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build()

            phrasesAPI = retrofit.create(PhrasesService::class.java)
        }
    }
}