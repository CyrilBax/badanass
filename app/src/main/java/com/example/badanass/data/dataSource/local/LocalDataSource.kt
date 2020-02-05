package com.example.badanass.data.dataSource.local

import com.example.badanass.data.models.Card

interface LocalDataSource {

    fun getCardList(): List<Card>

    fun getCard(id: Long): Card
}