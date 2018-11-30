package com.diogocabral.viperSampleApp.router

import android.app.Activity
import android.content.Intent
import com.diogocabral.viperSampleApp.view.PhrasesActivity

private const val PHRASE_INTENT_EXTRA = "initialPhrase"

fun goToPhrasesScreen(view: Activity, initialPhrase: String) {
    val intent = Intent(view, PhrasesActivity::class.java)
    intent.putExtra(PHRASE_INTENT_EXTRA, initialPhrase)
    view.startActivity(intent)
}