package com.huynn109.chappiebothometest.domain

import com.fernandocejas.frodo.annotation.RxLogObservable
import com.huynn109.chappiebothometest.data.entity.response.NewsDetailResponse
import com.huynn109.chappiebothometest.data.entity.response.NewsFeedResponse
import com.huynn109.chappiebothometest.data.source.local.LocalRepository
import com.huynn109.chappiebothometest.data.source.remote.ApiRepository
import io.reactivex.Single
import java.io.IOException

/**
 * Created by huynn109 on 4/8/19.
 */

interface NewsUseCase {
    fun getNewsFeed(): Single<NewsFeedResponse>
    fun getNewsDetail(): Single<NewsDetailResponse>
    fun getNewsFeedLocal(): Single<NewsFeedResponse>
    fun getNewsDetailLocal(): Single<NewsDetailResponse>
}

class NewsUseCaseImpl(private val apiRepository: ApiRepository, private val localRepository: LocalRepository) :
    NewsUseCase {

    @RxLogObservable(RxLogObservable.Scope.STREAM)
    override fun getNewsFeedLocal(): Single<NewsFeedResponse> {
        return localRepository.getNewsFeed()
    }
    override fun getNewsDetailLocal(): Single<NewsDetailResponse> {
        return localRepository.getNewsDetail()
    }

    override fun getNewsDetail(): Single<NewsDetailResponse> {
        return apiRepository.getNewsDetail()
    }

    override fun getNewsFeed(): Single<NewsFeedResponse> {
        return apiRepository.getNewsFeed()
    }

}