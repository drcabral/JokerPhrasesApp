package com.diogocabral.viperSampleApp.interactor.service

import com.diogocabral.viperSampleApp.entity.PhraseResultEntity
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface PhrasesService {

    @GET("random/{quantity}")
    fun fetchRandomPhrase(@Path("quantity") quantity : Int) : Call<PhraseResultEntity>
}