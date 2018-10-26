package com.diogocabral.viperSampleApp.interactor.service

import com.diogocabral.viperSampleApp.entity.PhraseResultEntity
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface PhrasesService {

    @GET("random/{quantity}")
    fun fetchRandomPhrase(@Path("quantity") quantity : Int) : Observable<PhraseResultEntity>
}