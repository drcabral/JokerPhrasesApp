package com.diogocabral.viperSampleApp.interactor

import com.diogocabral.viperSampleApp.entity.utils.getRandomElement
import com.diogocabral.viperSampleApp.interactor.service.PhrasesService
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class PhraseInteractor @Inject constructor(
        private val phrasesService: PhrasesService){
    fun fetchPhrases(): Observable<String?> {
        return phrasesService.fetchRandomPhrase(10)
                .map { it.phrases.getRandomElement()?.joke }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }
}