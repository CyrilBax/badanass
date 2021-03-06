package com.example.badanass.data.dataSource

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.badanass.data.models.Card

@Entity
data class DatabaseCard(
    @PrimaryKey(autoGenerate = false)
    var cardId: String,
    var name: String,
    var type: String,
    var img: String? = null
)

/*fun Observable<List<DatabaseCard>>.asDomainModel(): Observable<List<Card>> {
    return map { card ->
        card.map {
            Card(
                cardId = it.cardId,
                name = it.name,
                type = it.type,
                img = it.img
            )
        }
    }
}*/

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
