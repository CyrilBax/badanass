package com.example.badanass.domain.profiles

import com.example.badanass.data.dataSource.CardDao
import com.example.badanass.data.dataSource.local.LocalDataSource
import com.example.badanass.data.dataSource.local.LocalDataSourceImpl
import com.example.badanass.data.dataSource.asDomainModel
import com.example.badanass.data.models.Card
import dagger.Module
import dagger.Provides

@Module()
class LocalDataSourceModule {

    @Provides
    fun GetListCard(dao: CardDao): List<Card> {
        return dao.getAllCard().asDomainModel()
    }

    @Provides
    fun provideLocalDataSource(): LocalDataSource {
        return LocalDataSourceImpl()
    }
}