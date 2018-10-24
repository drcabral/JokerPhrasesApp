package com.diogocabral.viperSampleApp.presenter

import com.diogocabral.viperSampleApp.entity.PhraseEntity
import com.diogocabral.viperSampleApp.interactor.PhraseInteractor
import com.diogocabral.viperSampleApp.view.MainActivity
import java.util.*

class PhrasePresenter(var view: MainActivity) {

    var interactor: PhraseInteractor = PhraseInteractor()

    fun setPhraseOnView() {
        view.setPhraseText(generateRandomPhrase().joke)
    }

    private fun generateRandomPhrase(): PhraseEntity {
        interactor.fetchPhrases()
        var returnedPhrase = PhraseEntity(0, "Default Joke")

        interactor.phrasesResult.let {
            val randomIndex = generateRandomArrayIndex(it?.phrases as ArrayList<PhraseEntity>)
            returnedPhrase = it.phrases[randomIndex]
        }

        return returnedPhrase
    }

    private fun generateRandomArrayIndex(list: ArrayList<PhraseEntity>) : Int {
        return Random().nextInt(list.size)
    }
}