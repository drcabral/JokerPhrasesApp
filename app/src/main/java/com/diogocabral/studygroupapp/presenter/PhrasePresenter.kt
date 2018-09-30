package com.diogocabral.studygroupapp.presenter

import com.diogocabral.studygroupapp.entity.PhraseEntity
import com.diogocabral.studygroupapp.interactor.PhraseInteractor
import com.diogocabral.studygroupapp.view.MainActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class PhrasePresenter(var view: MainActivity) {

    var interactor: PhraseInteractor = PhraseInteractor()

    fun setPhraseOnView() {
        view.txt_phrase.text = generateRandomPhrase().text
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