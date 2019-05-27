package fr.larmik.kotlinproject.core.dagger

import android.app.Application
import dagger.Module
import dagger.Provides
import fr.larmik.kotlinproject.api.ApiServiceInterface
import fr.larmik.kotlinproject.manager.PreferenceManager
import fr.larmik.kotlinproject.service.PostService
import javax.inject.Singleton

@Module
class ApplicationModule(private val baseApp: Application) {

    @Provides
    @Singleton
    fun provideApplication(): Application {
        return baseApp
    }

    @Provides
    fun provideApiService(): ApiServiceInterface = ApiServiceInterface.create()

    @Provides
    fun providePreferences(): PreferenceManager = PreferenceManager(context = baseApp)

    //Services

    @Provides
    fun providePostService(apiServiceInterface: ApiServiceInterface): PostService = PostService(apiServiceInterface)

}