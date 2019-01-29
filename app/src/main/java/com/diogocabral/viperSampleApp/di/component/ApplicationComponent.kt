package com.diogocabral.viperSampleApp.di.component

import android.content.Context
import com.diogocabral.viperSampleApp.di.module.ApplicationModule
import com.diogocabral.viperSampleApp.di.module.ServiceModule
import com.diogocabral.viperSampleApp.interactor.service.PhrasesService
import dagger.Component

@Component(modules = [ApplicationModule::class, ServiceModule::class])
interface ApplicationComponent {
    fun getContext(): Context
    fun getPhrasesService(): PhrasesService
}