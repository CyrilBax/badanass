package com.example.badanass.data.dataSource

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface CardDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(card: List<DatabaseCard>)

    @Query("SELECT * FROM DatabaseCard WHERE name = :key")
    fun get(key: String): DatabaseCard?

    @Query("SELECT * FROM DatabaseCard ORDER BY cardId DESC")
    fun getAllCard(): List<DatabaseCard>
}