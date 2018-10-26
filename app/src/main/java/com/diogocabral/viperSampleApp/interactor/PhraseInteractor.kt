package com.diogocabral.viperSampleApp.interactor

import com.diogocabral.viperSampleApp.entity.utils.getRandomElement
import com.diogocabral.viperSampleApp.interactor.utils.HTTPManager
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


class PhraseInteractor {

    init {
        HTTPManager.createPhraseService()
    }

    fun fetchPhrases(): Observable<String?> {
        return HTTPManager.phrasesService.fetchRandomPhrase(10)
                .map { it.phrases.getRandomElement()?.joke }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }
}