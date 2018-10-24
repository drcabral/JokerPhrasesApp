package com.diogocabral.viperSampleApp.interactor

import android.util.Log
import com.diogocabral.viperSampleApp.entity.PhraseResultEntity
import com.diogocabral.viperSampleApp.interactor.utils.HTTPManager
import retrofit2.Callback
import retrofit2.Call
import retrofit2.Response


class PhraseInteractor : Callback<PhraseResultEntity> {

    var phrasesResult: PhraseResultEntity? = null

    constructor(){
        HTTPManager.createPhraseService()
    }

    fun fetchPhrases() {
        val callToApi = HTTPManager.phrasesAPI.fetchRandomPhrase(10)
        callToApi.enqueue(this)
    }

    override fun onResponse(call: Call<PhraseResultEntity>, response: Response<PhraseResultEntity>) {
        if (response.isSuccessful) {
            val phrasesResult = response.body() as PhraseResultEntity
            phrasesResult.phrases.forEach { phrase -> System.out.println(phrase.joke) }
        } else {
            System.out.println(response.errorBody())
        }
    }

    override fun onFailure(call: Call<PhraseResultEntity>, t: Throwable) {
        Log.e("onFailure error", t.message)
    }

}