package com.huynn109.chappiebothometest.di

import com.huynn109.chappiebothometest.data.source.remote.ApiService
import org.koin.dsl.module
import retrofit2.Retrofit

/**
 * Created by huynn109 on 4/7/19.
 */

val apiModule = module {
    factory { createApiService(get()) }
}

private fun createApiService(retrofit: Retrofit) =
    retrofit.create(ApiService::class.java)