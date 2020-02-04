package com.example.badanass.domain.profiles

import com.example.badanass.data.dataSrouce.CardDao
import com.example.badanass.data.dataSrouce.LocalDataSource
import com.example.badanass.data.dataSrouce.asDomainModel
import com.example.badanass.data.models.Card
import dagger.Module
import dagger.Provides

@Module
class LocalDataSourceModule {

    @Provides
    fun GetListCard(dao: CardDao): List<Card> {
        return dao.getAllCard().asDomainModel()
    }
}