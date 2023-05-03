package com.example.data.module

import com.example.data.remote.dataSource.RetrofitSource
import com.example.data.remote.dataSourceImpl.RetrofitSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

/**
 * 2023-05-03
 * pureum
 */
@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {
    @Provides
    @Singleton
    fun provideDataSourceModule(retrofit:Retrofit):RetrofitSource{
        return RetrofitSourceImpl(retrofit)
    }
}