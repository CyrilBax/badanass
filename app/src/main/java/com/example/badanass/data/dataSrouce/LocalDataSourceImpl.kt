package com.example.badanass.data.dataSrouce

import com.example.badanass.data.models.Card

class LocalDataSourceImpl {

    data class Card(val cardId: Long, val name: String)

    private val allCard = listOf(
        Card(1, "first"),
        Card(2, "two")
    )

    fun GetCardList() : List<Card> {
        return allCard
    }

    fun getCard(id: String): Card {
        return allCard[0]
    }
}