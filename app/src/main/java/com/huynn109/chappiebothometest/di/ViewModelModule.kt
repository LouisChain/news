package com.huynn109.chappiebothometest.di

import com.huynn109.chappiebothometest.view.account.AccountViewModel
import com.huynn109.chappiebothometest.view.home.HomeViewModel
import com.huynn109.chappiebothometest.view.home.follow.FollowViewModel
import com.huynn109.chappiebothometest.view.home.football.FootballViewModel
import com.huynn109.chappiebothometest.view.home.foryou.ForYouViewModel
import com.huynn109.chappiebothometest.view.home.life.LifeViewModel
import com.huynn109.chappiebothometest.view.home.tech.TechViewModel
import com.huynn109.chappiebothometest.view.notification.NotificationViewModel
import com.huynn109.chappiebothometest.viewmodel.MainViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by huynn109 on 4/7/19.
 */

val viewModelModule = module {
    viewModel { MainViewModel(get(), AndroidSchedulers.mainThread()) }
    viewModel { HomeViewModel() }
    viewModel { AccountViewModel() }
    viewModel { NotificationViewModel() }
    viewModel { FollowViewModel() }
    viewModel { FootballViewModel() }
    viewModel { ForYouViewModel(get(), AndroidSchedulers.mainThread()) }
    viewModel { LifeViewModel() }
    viewModel { TechViewModel() }
}