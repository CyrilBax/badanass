package com.example.badanass.domain.profiles

import com.example.badanass.data.dataSource.CardDao
import com.example.badanass.data.dataSource.asDomainModel
import com.example.badanass.data.dataSource.remote.RemoteDataSource
import com.example.badanass.data.dataSource.remote.RemoteDataSourceImpl
import com.example.badanass.data.models.Card
import com.example.badanass.data.models.CardMapper
import com.example.badanass.network.CardService
import dagger.Module
import dagger.Provides
import io.reactivex.Observable
import io.reactivex.Single

@Module
class RemoteDataSourceModule {

    @Provides
    fun provideRemoteDataSource(): RemoteDataSource {
        return RemoteDataSourceImpl()
    }
}