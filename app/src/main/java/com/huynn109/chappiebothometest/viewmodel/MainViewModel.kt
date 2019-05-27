package com.huynn109.chappiebothometest.viewmodel

import com.huynn109.chappiebothometest.base.BaseViewModel
import com.huynn109.chappiebothometest.domain.NewsUseCase
import io.reactivex.Scheduler
import timber.log.Timber
import java.util.concurrent.TimeUnit

/**
 * Created by huynn109 on 2019-05-22.
 */

class MainViewModel(private val newsUseCase: NewsUseCase, private val scheduler: Scheduler) : BaseViewModel() {
    fun test() {
        Timber.d("test")
        addDisposable(
            newsUseCase.getNewsFeedLocal().observeOn(scheduler).subscribe({
                Timber.d("Success ${it.items?.size.toString()}")
            }, {
                Timber.e("Error  $it")
            })
        )
        addDisposable(
            newsUseCase.getNewsDetailLocal().delay(2, TimeUnit.SECONDS).observeOn(scheduler).subscribe({
                Timber.d("Đợi xíu đi man ${it.title}")
            }, {
                Timber.e("Error  $it")
            })
        )
    }

}