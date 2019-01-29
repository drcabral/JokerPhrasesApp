package com.diogocabral.viperSampleApp.di.component

import com.diogocabral.viperSampleApp.di.module.MainModule
import com.diogocabral.viperSampleApp.view.MainActivity
import dagger.Component

@Component(modules = [MainModule::class], dependencies = [ApplicationComponent::class])
interface MainComponent {
    fun inject(mainActivity: MainActivity)
}