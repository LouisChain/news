package com.huynn109.chappiebothometest.data.source.remote


import com.huynn109.chappiebothometest.data.entity.response.NewsDetailResponse
import com.huynn109.chappiebothometest.data.entity.response.NewsFeedResponse
import io.reactivex.Single

/**
 * Created by huynn109 on 4/8/19.
 */

interface RemoteDataSource {
    fun getNewsFeed(): Single<NewsFeedResponse>
    fun getNewsDetail(): Single<NewsDetailResponse>
}