package fr.larmik.kotlinproject.tasks

import fr.larmik.kotlinproject.core.dagger.BaseApp
import fr.larmik.kotlinproject.core.retrofit.AbstractTask
import fr.larmik.kotlinproject.models.Post
import fr.larmik.kotlinproject.service.PostService
import javax.inject.Inject

class GetPostsTask : AbstractTask<List<Post>>() {
    @Inject
    lateinit var basicService: PostService

    override fun doCall(): List<Post> {
        BaseApp.component!!.inject(this)
        return basicService.getPosts()!!
    }
}