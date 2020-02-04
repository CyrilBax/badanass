package com.example.badanass.data.dataSrouce

import com.example.badanass.data.models.Card

interface LocalDataSource {

    fun getCardList(): List<Card>

    fun getCard(id: String): Card
}