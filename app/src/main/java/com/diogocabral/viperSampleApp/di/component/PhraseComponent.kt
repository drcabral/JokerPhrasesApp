package com.diogocabral.viperSampleApp.di.component

import com.diogocabral.viperSampleApp.di.module.PhraseModule
import com.diogocabral.viperSampleApp.view.PhrasesActivity
import dagger.Component

@Component(modules = [PhraseModule::class], dependencies = [ApplicationComponent::class])
interface PhraseComponent {
    fun inject(phrasesActivity: PhrasesActivity)
}