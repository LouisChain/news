package com.huynn109.chappiebothometest.data.source.remote

import com.huynn109.chappiebothometest.data.entity.response.NewsDetailResponse
import com.huynn109.chappiebothometest.data.entity.response.NewsFeedResponse
import io.reactivex.Scheduler
import io.reactivex.Single

/**
 * Created by huynn109 on 2019-05-23.
 */

class RemoteDataSourceImpl(private val apiService: ApiService, private val scheduler: Scheduler) : RemoteDataSource {
    override fun getNewsFeed(): Single<NewsFeedResponse> {
        return apiService.getNewsFeed().subscribeOn(scheduler)
    }

    override fun getNewsDetail(): Single<NewsDetailResponse> {
        return apiService.getNewsDetail().subscribeOn(scheduler)
    }

}