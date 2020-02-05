package com.example.badanass.domain.repository.impl

import com.example.badanass.data.dataSource.local.LocalDataSource
import com.example.badanass.data.models.Card
import com.example.badanass.domain.repository.CardRepository

class CardRepositoryImpl(private val dataSource: LocalDataSource): CardRepository {

    override fun getList(): List<Card> {
        return dataSource.getCardList()
    }

    override fun getCard(id: Long): Card? {
        return dataSource.getCard(id)
    }
}