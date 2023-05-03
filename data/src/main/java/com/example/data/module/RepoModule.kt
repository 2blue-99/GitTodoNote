package com.example.data.module

import com.example.data.remote.dataSource.RetrofitSource
import com.example.data.repoImpl.RetrofitRepoImpl
import com.example.domain.repo.RetrofitRepo
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
object RepoModule {
    @Provides
    @Singleton
    fun provideRepoModule(dataSource: RetrofitSource):RetrofitRepo{
        return RetrofitRepoImpl(dataSource)
    }
}