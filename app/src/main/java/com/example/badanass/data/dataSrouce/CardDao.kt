package com.example.badanass.data.dataSrouce

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface CardDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(card: List<DatabaseCard>)

    @Query("SELECT * FROM DatabaseCard WHERE cardId = :key")
    fun get(key: Long): DatabaseCard?

    @Query("SELECT * FROM DatabaseCard ORDER BY cardId DESC")
    fun getAllCard(): LiveData<List<DatabaseCard>>
}