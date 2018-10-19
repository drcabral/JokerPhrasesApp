package com.diogocabral.viperSampleApp.presenter

import com.diogocabral.viperSampleApp.entity.PhraseEntity
import com.diogocabral.viperSampleApp.interactor.PhraseInteractor
import com.diogocabral.viperSampleApp.view.MainActivity
import java.util.*

class PhrasePresenter(var view: MainActivity) {

    var interactor: PhraseInteractor = PhraseInteractor()

    fun setPhraseOnView() {
        view.setPhraseText(generateRandomPhrase().text)
    }

    private fun generateRandomPhrase(): PhraseEntity {
        interactor.fetchPhrases()
        var index = 0
        var returnedPhrase = PhraseEntity("teste")

        if(interactor.phrases.size > 0){
            index = generateRandomArrayIndex(interactor.phrases)
            returnedPhrase = interactor.phrases[index]
        }

        return returnedPhrase
    }

    private fun generateRandomArrayIndex(list: ArrayList<PhraseEntity>) : Int {
        return Random().nextInt(list.size)
    }
}