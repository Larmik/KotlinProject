package fr.larmik.kotlinproject.core.dagger

import android.app.Application
import android.content.Context

class BaseApp: Application() {

    override fun onCreate() {
        super.onCreate()
        appContext = applicationContext
        component = DaggerApplicationComponent.builder()
            .applicationModule(ApplicationModule(this))
            .build()
        component!!.inject(this)
    }

    companion object {
        var component: ApplicationComponent? = null
            private set
        var appContext: Context? = null
            private set
    }
}