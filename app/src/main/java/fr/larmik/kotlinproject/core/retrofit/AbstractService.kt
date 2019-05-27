package fr.larmik.kotlinproject.core.retrofit

import fr.larmik.kotlinproject.api.ApiServiceInterface
import fr.larmik.kotlinproject.core.dagger.BaseApp
import retrofit2.Call
import java.io.IOException

abstract class AbstractService(var apiServiceInterface: ApiServiceInterface) {

    init {
        BaseApp.component!!.inject(this)
    }

    @Throws(IOException::class)
    protected fun <R> execute(call: Call<R>): R? {
        val response = call.execute()
        if (response.isSuccessful) {
            return response.body()
        }

        throw IOException("Une erreur est survenue")
    }
}