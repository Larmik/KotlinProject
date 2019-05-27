package fr.larmik.kotlinproject.tasks

import fr.larmik.kotlinproject.core.dagger.BaseApp
import fr.larmik.kotlinproject.core.retrofit.AbstractTask
import fr.larmik.kotlinproject.models.DefaultResponse
import fr.larmik.kotlinproject.service.PostService
import javax.inject.Inject

class HomeTask() : AbstractTask<DefaultResponse>() {

    @Inject lateinit var postService: PostService


    override fun doCall(): DefaultResponse {
        BaseApp.component!!.inject(this)
        postService.home()
        return DefaultResponse()
    }
}