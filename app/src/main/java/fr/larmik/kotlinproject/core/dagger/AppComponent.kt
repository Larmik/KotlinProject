package fr.larmik.kotlinproject.core.dagger

import dagger.Component
import fr.larmik.kotlinproject.tasks.GetPostByIdTask
import fr.larmik.kotlinproject.tasks.GetPostsTask
import fr.larmik.kotlinproject.api.ApiServiceInterface
import fr.larmik.kotlinproject.core.abstractui.AbstractActivity
import fr.larmik.kotlinproject.core.abstractui.AbstractFragment
import fr.larmik.kotlinproject.core.retrofit.AbstractService
import fr.larmik.kotlinproject.tasks.HomeTask
import fr.larmik.kotlinproject.tasks.RegisterTask

@Component(modules = arrayOf(ApplicationModule::class))
interface ApplicationComponent {

    fun inject(application: BaseApp)

    fun inject(abstractActivity: AbstractActivity)

    fun inject(abstractFragment: AbstractFragment)

    fun inject(apiServiceInterface: ApiServiceInterface)

    fun inject(abstractService: AbstractService)

    //Tasks

    fun inject(getPostByIdTask: GetPostByIdTask)

    fun inject(getPostsTask: GetPostsTask)

    fun inject(registerTask: RegisterTask)

    fun inject(homeTask: HomeTask)

}