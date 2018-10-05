package com.diogocabral.jokerPhrasesApp.presenter

import com.diogocabral.jokerPhrasesApp.entity.PhraseEntity
import com.diogocabral.jokerPhrasesApp.interactor.PhraseInteractor
import com.diogocabral.jokerPhrasesApp.view.MainActivity
import kotlinx.android.synthetic.main.activity_main.*
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