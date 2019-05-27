package fr.larmik.kotlinproject.core.retrofit

import fr.larmik.kotlinproject.core.dagger.BaseApp
import io.reactivex.Single
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import java.io.IOException

abstract class AbstractTask<R> {

    private val single: Single<R>

    init {
        single = Single.create { singleEmitter ->
            try {
                val result = doCall()
                singleEmitter.onSuccess(result)
            } catch (e: Exception) {
                singleEmitter.onError(e)
            }
        }
    }

    fun execute(requestCallback: RequestCallback<R>) {
        single.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(getSubscriber(requestCallback))
    }

    @Throws(IOException::class)
    protected abstract fun doCall(): R

    private fun getSubscriber(requestCallback: RequestCallback<R>): SingleObserver<R> {
        return object : SingleObserver<R> {

            override fun onError(e: Throwable) {
                print(e.message)
                requestCallback.onError(e)
            }

            override fun onSubscribe(disposable: Disposable) {}

            override fun onSuccess(result: R) {
                requestCallback.onSuccess(result)
            }
        }
    }

}
