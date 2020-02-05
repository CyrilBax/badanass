package com.example.badanass.data.dataSource

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.badanass.data.models.Card

@Entity
data class DatabaseCard(
    @PrimaryKey(autoGenerate = false)
    var cardId: Long,
    var name: String
)

fun List<DatabaseCard>.asDomainModel(): List<Card> {
    return map {
        Card(
            cardId = it.cardId,
            name = it.name
        )
    }
}