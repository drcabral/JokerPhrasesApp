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
        val phrases = interactor.fetchPhrases()
        val index = generateRandomArrayIndex(phrases)
        return phrases[index]
    }

    private fun generateRandomArrayIndex(list: ArrayList<PhraseEntity>) : Int {
        return Random().nextInt(list.size)
    }
}