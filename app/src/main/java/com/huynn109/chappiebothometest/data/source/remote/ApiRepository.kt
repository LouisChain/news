package com.huynn109.chappiebothometest.data.source.remote

import com.huynn109.chappiebothometest.data.entity.response.NewsDetailResponse
import com.huynn109.chappiebothometest.data.entity.response.NewsFeedResponse
import com.huynn109.chappiebothometest.data.source.remote.RemoteDataSource
import io.reactivex.Single

/**
 * Created by huynn109 on 2019-04-22.
 */
class ApiRepository(private val remoteDataSourceImpl: RemoteDataSourceImpl) :
    RemoteDataSource {
    override fun getNewsDetail(): Single<NewsDetailResponse> {
        return remoteDataSourceImpl.getNewsDetail()
    }

    override fun getNewsFeed(): Single<NewsFeedResponse> {
        return remoteDataSourceImpl.getNewsFeed()
    }

}