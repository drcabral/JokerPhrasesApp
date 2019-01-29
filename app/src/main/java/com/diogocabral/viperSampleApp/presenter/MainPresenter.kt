package com.diogocabral.viperSampleApp.presenter

import android.util.Log
import com.diogocabral.viperSampleApp.interactor.PhraseInteractor
import com.diogocabral.viperSampleApp.router.goToPhrasesScreen
import com.diogocabral.viperSampleApp.view.MainActivity
import io.reactivex.disposables.Disposable
import javax.inject.Inject

class MainPresenter @Inject constructor(
        private val view: MainActivity,
        private val interactor: PhraseInteractor) {

    var disposable: Disposable? = null

    fun onSeePhraseClicked() {
        disposable = interactor.fetchPhrases().subscribe({ randomPhrase ->
            randomPhrase?.let {
                goToPhrasesScreen(view, randomPhrase)
            }
        }, { e ->
            Log.e("MainPresenter", e.message, e)
        })
    }

    fun disposeCalls() {
        if (disposable != null && disposable?.isDisposed == false) {
            disposable?.dispose()
        }
    }
}