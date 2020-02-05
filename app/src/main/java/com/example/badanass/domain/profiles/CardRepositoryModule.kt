package com.example.badanass.domain.profiles

import com.example.badanass.data.dataSource.local.LocalDataSource
import com.example.badanass.domain.repository.CardRepository
import com.example.badanass.domain.repository.impl.CardRepositoryImpl
import dagger.Module
import dagger.Provides

@Module(includes = [LocalDataSourceModule::class])
class CardRepositoryModule {

    @Provides
    fun provideCardRepository(localDataSource: LocalDataSource) : CardRepository {
        return CardRepositoryImpl(localDataSource)
    }
}