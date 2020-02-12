package com.example.badanass.domain.profiles

import androidx.room.Room
import com.example.badanass.BadanassApps
import com.example.badanass.data.dataSource.CardDao
import com.example.badanass.data.dataSource.CardDatabse
import com.example.badanass.data.dataSource.local.LocalDataSource
import com.example.badanass.data.dataSource.local.LocalDataSourceImpl
import com.example.badanass.data.dataSource.asDomainModel
import com.example.badanass.data.models.Card
import dagger.Module
import dagger.Provides
import io.reactivex.Observable

@Module
class LocalDataSourceModule {

    @Provides
    fun getListCard(dao: CardDao): List<Card> {
        return dao.getAllCard().asDomainModel()
    }

    @Provides
    fun provideLocalDataSource(dataBase: CardDatabse): LocalDataSource {
        return LocalDataSourceImpl(dataBase)
    }

    @Provides
    fun provideDatabase(): CardDatabse {
        return Room.databaseBuilder(BadanassApps.context.applicationContext,
            CardDatabse::class.java,
            "card").build()
    }

}
