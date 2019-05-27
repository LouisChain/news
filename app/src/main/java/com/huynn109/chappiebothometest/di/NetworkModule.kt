package com.huynn109.chappiebothometest.di

import android.content.Context
import com.google.gson.Gson
import com.huynn109.chappiebothometest.BuildConfig
import com.huynn109.chappiebothometest.data.source.remote.HostSelectionInterceptor
import okhttp3.Cache
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File

/**
 * Created by huynn109 on 4/8/19.
 */

val networkModule = module {
    single { createGson() }
    single { createInterceptor() }
    single { createHostInterceptor() }
    single { createOkHttpClient(androidContext(), get()) }
    single { createNetworkClient(get(), BuildConfig.BASE_URL) } // Setting api config build Type
}

private fun createGson(): Gson {
    return Gson()
}

private fun createNetworkClient(okHttpClient: OkHttpClient, baseUrl: String) = Retrofit
    .Builder()
    .baseUrl(baseUrl)
    .addConverterFactory(GsonConverterFactory.create())
    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
    .client(okHttpClient)
    .build()

private fun createOkHttpClient(context: Context, requestInterceptor: HostSelectionInterceptor): OkHttpClient {
    val cacheDir = File(context.cacheDir, "responses")
    val builder = OkHttpClient.Builder()
        .cache(Cache(cacheDir, 10 * 1024 * 1024)) //10Mb
        .addInterceptor(log(BuildConfig.DEBUG))
        .addInterceptor(requestInterceptor)
    return builder.build()
}

private fun createInterceptor() = Interceptor { chain ->
    val original = chain.request()
    val builder = original.newBuilder()
        .method(original.method(), original.body())
    val newRequest = builder.build()
    chain.proceed(newRequest)
}

private fun createHostInterceptor() = HostSelectionInterceptor().apply { setBaseUrl(BuildConfig.BASE_URL) }

private fun log(enabled: Boolean): Interceptor {
    val logging = HttpLoggingInterceptor()
    logging.level = if (enabled) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
    return logging
}