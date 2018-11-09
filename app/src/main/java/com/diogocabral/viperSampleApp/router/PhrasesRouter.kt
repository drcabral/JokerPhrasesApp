package com.diogocabral.viperSampleApp.router

import android.content.Intent
import com.diogocabral.viperSampleApp.view.MainActivity
import com.diogocabral.viperSampleApp.view.PhrasesActivity

private const val PHRASE_INTENT_EXTRA = "initialPhrase"

class PhrasesRouter(var view: MainActivity) {

    fun goToPhrasesScreen(initialPhrase: String) {
        val intent = Intent(view, PhrasesActivity::class.java)
        intent.putExtra(PHRASE_INTENT_EXTRA, initialPhrase)
        view.startActivity(intent)
    }
}