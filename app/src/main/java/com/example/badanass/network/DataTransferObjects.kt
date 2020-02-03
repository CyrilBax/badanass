package com.example.badanass.network

import com.example.badanass.data.dataSrouce.DatabaseCard
import com.example.badanass.data.models.Card
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NetworkCardContainer(val videos: List<NetworkCard>)

/**
 * Videos represent a devbyte that can be played.
 */
@JsonClass(generateAdapter = true)
data class NetworkCard(
    val cardId: Long,
    val name: String,
    val type: String,
    val img: String
)

/**
 * Convert Network results to database objects
 */
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

/**
 * Convert Network results to database objects
 */
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
