package com.example.badanass.domain.profiles

import android.content.Context
import androidx.room.Room
import com.example.badanass.data.dataSource.CardDao
import com.example.badanass.data.dataSource.CardDatabse
import dagger.Module
import dagger.Provides

@Module
class CardDaoModule {

    @Provides
    fun provideCardDao(context: Context): CardDao {
        return Room.databaseBuilder(
            context.applicationContext,
            CardDatabse::class.java,
            "sleep_history_database"
        )
            .fallbackToDestructiveMigration()
            .build().cardDao
    }
}