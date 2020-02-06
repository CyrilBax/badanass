package com.example.badanass.domain.usecases

import androidx.lifecycle.LiveData
import com.example.badanass.data.models.Card
import com.example.badanass.domain.repository.CardRepository

class GetCardUseCase(private val repository: CardRepository) {

    fun execute(id: String): Card? {
        return repository.getCard(id)
    }
}