package com.huynn109.chappiebothometest.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.huynn109.chappiebothometest.util.Event
import com.trio.driver.data.entity.response.BaseResponse
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * Created by huynn109 on 4/7/19.
 */
open class BaseViewModel : ViewModel() {

    private val compositeDisposable = CompositeDisposable()
    val eventLoading = MutableLiveData<Event<Boolean>>()
    val eventError = MutableLiveData<Event<BaseResponse>>()
    val eventFailure = MutableLiveData<Event<Throwable>>()

    fun showLoading(value: Boolean) {
        eventLoading.value = Event(value)
    }

    fun showError(baseResponse: BaseResponse) {
        eventError.value = Event(baseResponse)
    }

    fun showFailure(throwable: Throwable) {
        eventFailure.value = Event(throwable)
    }

    fun addDisposable(disposable: Disposable) {
        compositeDisposable.add(disposable)
    }

    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }


}

