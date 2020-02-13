package com.example.badanass.domain.profiles

import com.example.badanass.data.dataSource.remote.RemoteDataSource
import com.example.badanass.data.dataSource.remote.RemoteDataSourceImpl
import dagger.Module
import dagger.Provides

@Module
class RemoteDataSourceModule {

    @Provides
    fun provideRemoteDataSource(): RemoteDataSource {
        return RemoteDataSourceImpl()
    }
}