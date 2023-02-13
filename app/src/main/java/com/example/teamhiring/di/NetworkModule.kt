package com.example.teamhiring.di

import com.example.teamhiring.data.constants.Constant
import com.example.teamhiring.data.services.ReferenceApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {


    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Constant.BASE_URL)
            .build()
    }

    @Provides
    @Singleton
    fun provideReferenceApiService(retrofit: Retrofit): ReferenceApiService =
        retrofit.create(ReferenceApiService::class.java)

}