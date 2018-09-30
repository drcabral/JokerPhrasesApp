package com.diogocabral.studygroupapp.interactor

import com.diogocabral.studygroupapp.entity.PhraseEntity

class PhraseInteractor {

    private var phrases: ArrayList<PhraseEntity> = ArrayList()

    fun fetchPhrases(): ArrayList<PhraseEntity> {
        generatePhrases()
        return phrases
    }

    private fun generatePhrases() {
        var localPhrases = arrayListOf(
                "If you're good at something, never do it for free.",
                "It's not about money...it’s about sending a message. Everything burns!",
                "I believe, whatever doesn't kill you, simply makes you...stranger.",
                "Why so serious?",
                "Nobody panics when things go “according to plan”. Even if the plan is horrifying!"
        )

        for (text in localPhrases) phrases.add(PhraseEntity(text))
    }

}