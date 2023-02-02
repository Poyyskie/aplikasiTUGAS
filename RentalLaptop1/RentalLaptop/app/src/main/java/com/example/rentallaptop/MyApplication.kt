package com.example.rentallaptop

import android.app.Application
import com.example.core.di.databaseModule
import com.example.core.di.preferencesModule
import com.example.core.di.repositoryModule
import com.example.rentallaptop.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.loadKoinModules
import org.koin.core.context.startKoin

class MyApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyApplication)
            loadKoinModules(databaseModule)
            loadKoinModules(repositoryModule)
            loadKoinModules(preferencesModule)
            loadKoinModules(viewModelModule)
        }
    }
}