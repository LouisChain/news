package com.huynn109.chappiebothometest.data.source.local

import com.huynn109.chappiebothometest.data.entity.response.NewsDetailResponse
import com.huynn109.chappiebothometest.data.entity.response.NewsFeedResponse
import io.reactivex.Single

/**
 * Created by huynn109 on 2019-05-23.
 */

interface LocalDataSource{
    fun getAssetsJson(fileName: String): String
    fun getNewsFeedAsset(fileName: String): Single<NewsFeedResponse>
    fun getNewsDetailAsset(fileName: String): Single<NewsDetailResponse>
}