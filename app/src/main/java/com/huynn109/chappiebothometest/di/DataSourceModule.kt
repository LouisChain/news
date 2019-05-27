package com.huynn109.chappiebothometest.di

import com.huynn109.chappiebothometest.data.source.local.LocalDataSourceImpl
import com.huynn109.chappiebothometest.data.source.remote.RemoteDataSourceImpl
import io.reactivex.schedulers.Schedulers
import org.koin.dsl.module

/**
 * Created by huynn109 on 4/7/19.
 */

val dataSourceModule = module {
    factory { RemoteDataSourceImpl(get(), Schedulers.io()) }
    factory { LocalDataSourceImpl(get(), get(), Schedulers.io()) }
}