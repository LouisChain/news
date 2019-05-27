package com.huynn109.chappiebothometest.di
import com.huynn109.chappiebothometest.domain.NewsUseCase
import com.huynn109.chappiebothometest.domain.NewsUseCaseImpl
import org.koin.dsl.module

/**
 * Created by huynn109 on 4/7/19.
 */

val useCaseModule = module {
    factory<NewsUseCase> { NewsUseCaseImpl(get(), get()) }
}

