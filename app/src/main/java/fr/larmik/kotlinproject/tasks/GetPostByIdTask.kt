package fr.larmik.kotlinproject.tasks

import fr.larmik.kotlinproject.core.dagger.BaseApp
import fr.larmik.kotlinproject.core.retrofit.AbstractTask
import fr.larmik.kotlinproject.models.Post
import fr.larmik.kotlinproject.service.PostService
import javax.inject.Inject

class GetPostByIdTask(val id: String) : AbstractTask<Post>() {

    @Inject
    lateinit var basicService: PostService

    override fun doCall(): Post {
        BaseApp.component!!.inject(this)
        return basicService.getPostById(id)!!
    }
}