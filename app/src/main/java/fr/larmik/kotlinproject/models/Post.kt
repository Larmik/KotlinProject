package fr.larmik.kotlinproject.models

import kotlinx.serialization.Serializable

@Serializable
data class Post(var userId: Int, var id: Int,
                var title: String, var body: String)