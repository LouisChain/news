package com.huynn109.chappiebothometest.data.source.local

import com.huynn109.chappiebothometest.data.entity.response.NewsDetailResponse
import com.huynn109.chappiebothometest.data.entity.response.NewsFeedResponse
import com.huynn109.chappiebothometest.data.source.remote.RemoteDataSource
import io.reactivex.Single

/**
 * Created by huynn109 on 2019-05-23.
 */

class LocalRepository(private val localDataSourceImpl: LocalDataSourceImpl) :
    RemoteDataSource {

    override fun getNewsDetail(): Single<NewsDetailResponse> {
        return localDataSourceImpl.getNewsDetailAsset(fileName = "newsdetail.json")
    }

    override fun getNewsFeed(): Single<NewsFeedResponse> {
        return localDataSourceImpl.getNewsFeedAsset(fileName = "newsfeed.json")
    }

}