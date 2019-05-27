package com.huynn109.chappiebothometest.di

import com.huynn109.chappiebothometest.data.source.local.LocalRepository
import com.huynn109.chappiebothometest.data.source.remote.ApiRepository
import org.koin.dsl.module

/**
 * Created by huynn109 on 4/7/19.
 */

val repositoryModule = module {
    factory { ApiRepository(get()) }
    factory { LocalRepository(get()) }
}