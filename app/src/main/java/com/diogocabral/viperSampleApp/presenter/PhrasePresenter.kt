package com.diogocabral.viperSampleApp.presenter

import android.util.Log
import com.diogocabral.viperSampleApp.entity.PhraseEntity
import com.diogocabral.viperSampleApp.interactor.PhraseInteractor
import com.diogocabral.viperSampleApp.view.MainActivity
import io.reactivex.disposables.Disposable
import java.util.*

class PhrasePresenter(var view: MainActivity) {

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

    fun disposeCalls() {
        if (disposable != null && disposable?.isDisposed == false) {
            disposable?.dispose()
        }
    }
}