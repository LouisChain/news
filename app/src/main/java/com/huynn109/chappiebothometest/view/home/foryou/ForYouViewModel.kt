package com.huynn109.chappiebothometest.view.home.foryou

import androidx.lifecycle.MutableLiveData
import com.huynn109.chappiebothometest.base.BaseViewModel
import com.huynn109.chappiebothometest.data.entity.response.NewsFeedResponse
import com.huynn109.chappiebothometest.domain.NewsUseCase
import io.reactivex.Scheduler
import com.huynn109.chappiebothometest.data.entity.binding.NewsItemViewModel
import io.reactivex.Observable
import io.reactivex.Single
import timber.log.Timber

/**
 * Created by huynn109 on 2019-05-24.
 */
class ForYouViewModel(private val newsUseCase: NewsUseCase, private val scheduler: Scheduler) : BaseViewModel() {

    var newsItemsLiveData: MutableLiveData<List<NewsItemViewModel>> = MutableLiveData()

    init {
        fetchNewsFeed()
    }

    fun fetchNewsFeed() {
        addDisposable(
                newsUseCase.getNewsFeedLocal()
                        .flatMap { getViewModelList(it.items) }
                        .observeOn(scheduler)
                        .subscribe({
                            for (item in it) Timber.d(item.contentType.get())
                            newsItemsLiveData.value = it
                        }, {
                            Timber.e(it)
                        })
        )
    }

    private fun getViewModelList(itemList: List<NewsFeedResponse.Item?>?): Single<List<NewsItemViewModel>>? {
        for (item in itemList!!) Timber.d(item?.content.toString())
        return Observable.fromIterable(itemList)
                .map { item ->
                    NewsItemViewModel(
                            contentType = item.contentType,
                            title = item.title,
                            content = item.content,
                            description = item.description,
                            avatar = item.avatar,
                            publisher = item.publisher,
                            publishedDate = item.publishedDate,
                            images = item.images
                    )
                }.toList()
    }
}