package com.diogocabral.viperSampleApp.presenter

import android.util.Log
import com.diogocabral.viperSampleApp.interactor.PhraseInteractor
import com.diogocabral.viperSampleApp.view.PhrasesActivity
import io.reactivex.disposables.Disposable
import javax.inject.Inject

private const val PHRASE_INTENT_EXTRA = "initialPhrase"

class PhrasePresenter @Inject constructor(
        private val view: PhrasesActivity,
        private val interactor: PhraseInteractor) {

    var disposable: Disposable? = null

    fun generateRandomPhrase() {
        disposable = interactor.fetchPhrases().subscribe({ randomPhrase ->
            randomPhrase?.let {
                view.setPhraseText(randomPhrase)
            }
        }, { e ->
            Log.e("PhrasePresenter", e.message, e)
        })
    }

    fun setInitialPhrase() {
        val intent = view.intent
        val initialPhrase = intent.getStringExtra(PHRASE_INTENT_EXTRA)
        view.setPhraseText(initialPhrase)
    }

    fun disposeCalls() {
        if (disposable != null && disposable?.isDisposed == false) {
            disposable?.dispose()
        }
    }
}