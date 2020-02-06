package com.example.badanass.domain.profiles

import com.example.badanass.data.dataSource.local.LocalDataSource
import com.example.badanass.data.dataSource.remote.RemoteDataSource
import com.example.badanass.domain.repository.CardRepository
import com.example.badanass.domain.repository.impl.CardRepositoryImpl
import dagger.Module
import dagger.Provides

@Module(includes = [LocalDataSourceModule::class, RemoteDataSourceModule::class])
class CardRepositoryModule {

    @Provides
    fun provideCardRepository(localDataSource: LocalDataSource, remoteDataSource: RemoteDataSource) : CardRepository {
        return CardRepositoryImpl(localDataSource, remoteDataSource)
    }
}