package fr.larmik.kotlinproject.core.abstractui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import fr.larmik.kotlinproject.api.ApiServiceInterface
import fr.larmik.kotlinproject.core.dagger.BaseApp
import fr.larmik.kotlinproject.core.dagger.ApplicationComponent
import fr.larmik.kotlinproject.manager.PreferenceManager
import javax.inject.Inject

abstract class AbstractActivity : AppCompatActivity() {

    @Inject lateinit var preferenceManager: PreferenceManager

    val applicationComponent: ApplicationComponent
        get() = BaseApp.component!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
        applicationComponent.inject(this)

    }

    //TODO implement common methods to all activities


}
