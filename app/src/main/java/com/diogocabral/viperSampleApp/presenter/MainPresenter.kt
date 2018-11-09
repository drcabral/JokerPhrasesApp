package com.diogocabral.viperSampleApp.presenter

import android.util.Log
import com.diogocabral.viperSampleApp.interactor.PhraseInteractor
import com.diogocabral.viperSampleApp.router.PhrasesRouter
import com.diogocabral.viperSampleApp.view.MainActivity
import io.reactivex.disposables.Disposable

class MainPresenter(var view: MainActivity) {

    var interactor: PhraseInteractor = PhraseInteractor()
    var disposable: Disposable? = null
    var router: PhrasesRouter = PhrasesRouter(view)

    fun onSeePhraseClicked() {
        disposable = interactor.fetchPhrases().subscribe({ randomPhrase ->
            randomPhrase?.let {
                router.goToPhrasesScreen(randomPhrase)
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