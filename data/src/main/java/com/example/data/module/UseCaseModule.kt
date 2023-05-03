package com.example.data.module

import com.example.domain.repo.RetrofitRepo
import com.example.domain.usecase.RetrofitUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * 2023-05-03
 * pureum
 */
@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {
    @Provides
    @Singleton
    fun provideUseCase(repo:RetrofitRepo): RetrofitUseCase { return RetrofitUseCase(repo) }

}