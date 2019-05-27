package fr.larmik.kotlinproject.api

import fr.larmik.kotlinproject.models.DefaultResponse
import fr.larmik.kotlinproject.models.LoginPayload
import fr.larmik.kotlinproject.models.Post
import fr.larmik.kotlinproject.models.User
import fr.larmik.kotlinproject.utils.BASE_URL
import retrofit2.Call
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path


interface ApiServiceInterface {


    companion object Factory {
        fun create(): ApiServiceInterface {
            val retrofit = retrofit2.Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()

            return retrofit.create(ApiServiceInterface::class.java)
        }
    }

    @GET("/posts/{id}")
    fun getPostById(@Path("id") id: String): Call<Post>

    @GET("/posts")
    fun getPosts(): Call<List<Post>>

    @POST("/login")
    fun login(payload: LoginPayload) : Call<User>

    @POST("/register")
    fun register(@Body payload: User) : Call<User>

    @GET("/home")
    fun home() : Call<DefaultResponse>

}