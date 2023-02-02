package com.example.core.di

import androidx.datastore.preferences.preferencesDataStore
import androidx.room.Room
import com.example.core.data.source.local.LocalDataSource
import com.example.core.data.source.local.room.Database
import com.example.core.data.source.preferences.UserPreferences
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val databaseModule = module {
    factory { get<Database>().dao() }
    single {
        Room.databaseBuilder(
            androidContext(),
            Database::class.java, "User.db"
        ).fallbackToDestructiveMigration()
            .build()
    }
}

val preferencesModule = module {
    single {
        preferencesDataStore(name = "user").getValue(
            androidContext(),
            UserPreferences::javaClass
        )
    }
    single {
        UserPreferences(get())
    }
}

val repositoryModule = module {
    single { LocalDataSource(get(), get()) }
}