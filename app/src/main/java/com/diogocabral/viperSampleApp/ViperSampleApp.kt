package com.diogocabral.viperSampleApp

import android.app.Application
import com.diogocabral.viperSampleApp.di.component.ApplicationComponent
import com.diogocabral.viperSampleApp.di.component.DaggerApplicationComponent
import com.diogocabral.viperSampleApp.di.module.ApplicationModule

class ViperSampleApp: Application() {

    private lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        applicationComponent = DaggerApplicationComponent
                .builder()
                .applicationModule(ApplicationModule(applicationContext))
                .build()
    }

    fun getApplicationComponent(): ApplicationComponent {
        return applicationComponent
    }
}