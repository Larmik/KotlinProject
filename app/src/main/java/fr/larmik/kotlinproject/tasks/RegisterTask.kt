package fr.larmik.kotlinproject.tasks

import fr.larmik.kotlinproject.core.dagger.BaseApp
import fr.larmik.kotlinproject.core.retrofit.AbstractTask
import fr.larmik.kotlinproject.models.User
import fr.larmik.kotlinproject.service.PostService
import javax.inject.Inject

class RegisterTask(val payload: User) : AbstractTask<User>() {
    @Inject lateinit var postService: PostService;

    override fun doCall(): User {
        BaseApp.component!!.inject(this)
        return postService.register(payload)!!
    }
}