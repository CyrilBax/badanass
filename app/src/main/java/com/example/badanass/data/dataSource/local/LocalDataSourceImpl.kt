package com.example.badanass.data.dataSource.local

import com.example.badanass.data.models.Card

class LocalDataSourceImpl(): LocalDataSource {

    private val allCard = listOf(
        Card(1, "first"),
        Card(2, "two")
    )

    override fun getCardList(): List<Card> {
        return allCard
    }

    override fun getCard(id: Long): Card {
        return allCard[0]
    }
}