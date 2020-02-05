package com.example.badanass.domain.repository

import com.example.badanass.data.models.Card

interface CardRepository {

    fun getList(): List<Card>

    fun getCard(id: Long): Card?
}