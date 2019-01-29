package com.diogocabral.viperSampleApp.di.module

import com.diogocabral.viperSampleApp.view.PhrasesActivity
import dagger.Module
import dagger.Provides

@Module
class PhraseModule(private val phrasesActivity: PhrasesActivity) {

    @Provides
    fun providesPhrasesActivity(): PhrasesActivity = phrasesActivity

}