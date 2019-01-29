package com.diogocabral.viperSampleApp.view.utils

import android.app.Activity
import com.diogocabral.viperSampleApp.ViperSampleApp
import com.diogocabral.viperSampleApp.di.component.DaggerMainComponent
import com.diogocabral.viperSampleApp.di.component.DaggerPhraseComponent
import com.diogocabral.viperSampleApp.di.module.MainModule
import com.diogocabral.viperSampleApp.di.module.PhraseModule
import com.diogocabral.viperSampleApp.view.MainActivity
import com.diogocabral.viperSampleApp.view.PhrasesActivity

val Activity.applicationComponent get() = (application as ViperSampleApp).getApplicationComponent()
val MainActivity.mainActivityComponent get() = DaggerMainComponent
        .builder()
        .applicationComponent(applicationComponent)
        .mainModule(MainModule(this))
        .build()
val PhrasesActivity.phraseActivityComponent get() = DaggerPhraseComponent
        .builder()
        .applicationComponent(applicationComponent)
        .phraseModule(PhraseModule(this))
        .build()