package com.huynn109.chappiebothometest.data.source.local

import android.content.Context
import com.google.gson.Gson
import com.huynn109.chappiebothometest.data.entity.response.NewsDetailResponse
import com.huynn109.chappiebothometest.data.entity.response.NewsFeedResponse
import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers

/**
 * Created by huynn109 on 2019-05-23.
 */

class LocalDataSourceImpl(private val gson: Gson, private val context: Context, private val scheduler: Scheduler) :
    LocalDataSource {

    override fun getAssetsJson(fileName: String): String {
        return context.assets.open(fileName).run {
            this.readBytes().toString(Charsets.UTF_8)
        }
    }

    /**
     * @param fileName file name json
     * @param onError any thrown exceptions will be passed to this handler.
     */
    private inline fun getAssets(fileName: String, onSuccess: (String) -> String, onError: (Exception) -> Unit) {
        try {
            onSuccess(getAssetsJson(fileName))
        } catch (exception: Exception) {
            onError(exception)
        }
    }


    override fun getNewsFeedAsset(fileName: String): Single<NewsFeedResponse> {
        getAssets(fileName, onSuccess = {
            return@getNewsFeedAsset Single.just(gson.fromJson(it, NewsFeedResponse::class.java)).subscribeOn(AndroidSchedulers.mainThread())
        }, onError = {
            return@getNewsFeedAsset Single.error(it)
        })
        return Single.error(Exception("~~~~~~~~~~~????? getNewsFeedAsset"))
    }

    override fun getNewsDetailAsset(fileName: String): Single<NewsDetailResponse> {
        getAssets(fileName, onSuccess = {
            return@getNewsDetailAsset Single.just(gson.fromJson(it, NewsDetailResponse::class.java)).subscribeOn(scheduler)
        }, onError = {
            return@getNewsDetailAsset Single.error(it)
        })
        return Single.error(Exception("~~~~~~~~~~~????? getNewsDetailAsset"))
    }
}