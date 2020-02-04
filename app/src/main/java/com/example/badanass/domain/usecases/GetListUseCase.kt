package com.example.badanass.domain.usecases

import com.example.badanass.data.models.Card
import com.example.badanass.domain.repository.CardRepository

class GetListUseCase(private val repository: CardRepository) {

    fun execute(): List<Card> {
        return repository.getList()
    }
}