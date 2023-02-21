package com.example.teamhiring.di

import com.example.teamhiring.data.constants.Constant
import com.example.teamhiring.data.services.RecruitManageApiService
import com.example.teamhiring.data.services.RecruiterApiService
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
    fun provideBaseUrl() = Constant.BASE_URL

    @Provides
    @Singleton
    fun provideRetrofit(baseUrl: String): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(baseUrl)
            .build()
    }

    @Provides
    @Singleton
    fun provideReferenceApiService(retrofit: Retrofit): ReferenceApiService =
        retrofit.create(ReferenceApiService::class.java)

    @Provides
    @Singleton
    fun provideRecruiterApiService(retrofit: Retrofit): RecruiterApiService =
        retrofit.create(RecruiterApiService::class.java)

    @Provides
    @Singleton
    fun provideRecruitManageApiService(retrofit: Retrofit): RecruitManageApiService =
        retrofit.create(RecruitManageApiService::class.java)

}