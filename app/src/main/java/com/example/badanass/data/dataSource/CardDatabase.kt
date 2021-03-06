package com.example.badanass.data.dataSource

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [DatabaseCard::class], version = 1, exportSchema = false)
abstract class CardDatabse: RoomDatabase() {
    abstract  val cardDao: CardDao
}

private lateinit var INSTANCE: CardDatabse

fun getDatabase(context: Context): CardDatabse {
    synchronized(CardDatabse::class.java) {
        if (!::INSTANCE.isInitialized) {
            INSTANCE = Room.databaseBuilder(context.applicationContext,
                CardDatabse::class.java,
                "card").build()
        }
    }
    return INSTANCE
}