package com.huynn109.chappiebothometest.data.source.remote


import com.huynn109.chappiebothometest.data.entity.response.NewsDetailResponse
import com.huynn109.chappiebothometest.data.entity.response.NewsFeedResponse
import com.trio.driver.data.entity.response.BaseResponse
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.*

/**
 * Created by huynn109 on 4/8/19.
 */

interface ApiService {
    @GET("/v2/5ce56e052e0000a38cf83de1")
    fun getNewsFeed(): Single<NewsFeedResponse>

    @GET("/s/v83n38kvsm6qw62/detail.json?dl=1")
    fun getNewsDetail(): Single<NewsDetailResponse>
}