package com.example.badanass.data.dataSource

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.badanass.data.models.Card
import io.reactivex.Maybe
import io.reactivex.Observable
import io.reactivex.Single

@Entity
data class DatabaseCard(
    @PrimaryKey(autoGenerate = false)
    var cardId: String,
    var name: String,
    var type: String,
    var img: String? = null
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