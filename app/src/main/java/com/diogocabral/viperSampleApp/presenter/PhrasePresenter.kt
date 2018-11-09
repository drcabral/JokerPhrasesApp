package com.diogocabral.viperSampleApp.presenter

import android.util.Log
import com.diogocabral.viperSampleApp.interactor.PhraseInteractor
import com.diogocabral.viperSampleApp.view.PhrasesActivity
import io.reactivex.disposables.Disposable

private const val PHRASE_INTENT_EXTRA = "initialPhrase"

class PhrasePresenter(var view: PhrasesActivity) {

    var interactor: PhraseInteractor = PhraseInteractor()
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