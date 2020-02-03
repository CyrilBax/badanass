package com.example.badanass.data.dataSrouce

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.badanass.data.models.Card

@Entity
data class DatabaseCard(
    @PrimaryKey(autoGenerate = false)
    var cardId: Long,
    var name: String,
    var type: String,
    var img: String
)

fun List<DatabaseCard>.asDomainModel(): List<Card> {
    return map {
        Card(
            cardId = it.cardId,
            name = it.name,
            type = it.type,
            img = it.img
        )
    }
}