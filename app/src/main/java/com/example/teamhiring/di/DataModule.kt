package com.example.teamhiring.di

import android.content.Context
import com.example.teamhiring.storage.DataStoreManager
import com.example.teamhiring.storage.DataStoreManagerImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@InstallIn (SingletonComponent::class)
@Module
class DataModule {

    @Provides
    @Singleton
    fun provideDataStoreManager(@ApplicationContext appContext : Context): DataStoreManager {
        return DataStoreManagerImpl(appContext)
    }
}