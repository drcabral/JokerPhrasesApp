package com.diogocabral.viperSampleApp.di.component

import android.content.Context
import com.diogocabral.viperSampleApp.di.module.ApplicationModule
import dagger.Component

@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {
    fun getContext(): Context
}