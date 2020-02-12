package com.example.badanass.data.dataSource

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.reactivex.Observable

@Dao
interface CardDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(card: List<DatabaseCard>)

    @Query("SELECT * FROM DatabaseCard WHERE name = :key")
    fun get(key: String): Observable<DatabaseCard>?

    @Query("SELECT * FROM DatabaseCard ORDER BY cardId DESC")
    fun getAllCard(): List<DatabaseCard>
}