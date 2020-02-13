package com.example.badanass.network

import com.example.badanass.data.dataSource.DatabaseCard
import com.example.badanass.data.models.Card
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NetworkCardContainer(val videos: List<NetworkCard>)


@JsonClass(generateAdapter = true)
data class NetworkCard(
    val cardId: String,
    val name: String,
    val type: String,
    val img: String
)


fun NetworkCardContainer.asDomainModel(): List<Card> {
    return videos.map {
        Card(
            cardId = it.cardId,
            name = it.name,
            type = it.type,
            img = it.img
        )
    }
}


fun NetworkCardContainer.asDatabaseModel(): List<DatabaseCard> {
    return videos.map {
        DatabaseCard(
            cardId = it.cardId,
            name = it.name,
            type = it.type,
            img = it.img
        )
    }
}
