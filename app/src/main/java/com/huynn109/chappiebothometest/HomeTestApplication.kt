package com.huynn109.chappiebothometest

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import com.huynn109.chappiebothometest.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import timber.log.Timber

/**
 * Created by huynn109 on 2019-05-21.
 */
class HomeTestApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES) // Theme

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

        startKoin {
            androidContext(this@HomeTestApplication)
            modules(
                    apiModule,
                    networkModule,
                    dataSourceModule,
                    repositoryModule,
                    useCaseModule,
                    viewModelModule
            )
        }
    }
}