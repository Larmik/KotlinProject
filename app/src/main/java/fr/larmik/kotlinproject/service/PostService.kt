package fr.larmik.kotlinproject.service

import fr.larmik.kotlinproject.api.ApiServiceInterface
import fr.larmik.kotlinproject.core.retrofit.AbstractService
import fr.larmik.kotlinproject.models.User

class PostService(apiServiceInterface: ApiServiceInterface) : AbstractService(apiServiceInterface) {

    fun getPostById(id: String) = execute(apiServiceInterface.getPostById(id))

    fun getPosts() = execute(apiServiceInterface.getPosts())

    fun register(payload : User) = execute(apiServiceInterface.register(payload))

    fun home() = execute(apiServiceInterface.home())

}