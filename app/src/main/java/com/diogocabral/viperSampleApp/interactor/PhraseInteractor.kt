package com.diogocabral.viperSampleApp.interactor

import android.util.Log
import com.diogocabral.viperSampleApp.entity.PhraseEntity
import com.diogocabral.viperSampleApp.interactor.service.PhrasesService
import com.google.gson.GsonBuilder
import retrofit2.Callback
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class PhraseInteractor : Callback<List<PhraseEntity>> {

    var phrases: ArrayList<PhraseEntity> = ArrayList()
    private val BASE_PHRASES_URL : String = "http://api.icndb.com/jokes/"
    private var phrasesAPI : PhrasesService

    constructor(){
        val gson = GsonBuilder()
                .setLenient()
                .create()

        val retrofit = Retrofit.Builder()
                .baseUrl(BASE_PHRASES_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()

        phrasesAPI = retrofit.create(PhrasesService::class.java)
    }

    fun fetchPhrases() {
        val callToApi = phrasesAPI.fetchRandomPhrase(10)
        callToApi.enqueue(this)
    }

    override fun onResponse(call: Call<List<PhraseEntity>>, response: Response<List<PhraseEntity>>) {
        if (response.isSuccessful) {
            val phrases = response.body()
            phrases.forEach { phrase -> System.out.println(phrase.text) }
        } else {
            System.out.println(response.errorBody())
        }
    }

    override fun onFailure(call: Call<List<PhraseEntity>>, t: Throwable) {
        Log.e("onFailure error", t?.message)
    }

}