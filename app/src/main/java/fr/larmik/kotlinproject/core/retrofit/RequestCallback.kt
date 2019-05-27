package fr.larmik.kotlinproject.core.retrofit


abstract class RequestCallback<Result> {

    abstract fun onSuccess(result: Result)

    fun onError(e: Throwable): Boolean {
        try {
            print(e)
            throw e
        } catch (throwable: Throwable) {
            print(throwable)
        }
        return true
    }

}