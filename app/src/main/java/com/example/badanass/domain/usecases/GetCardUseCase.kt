package com.example.badanass.domain.usecases

import androidx.lifecycle.LiveData
import com.example.badanass.data.models.Card
import com.example.badanass.domain.repository.CardRepository

class GetCardUseCase(private val repository: CardRepository, private val id: String) {

    fun execute(id: String): Card? {
        //TODO: repository.GetCard(id)
        return repository.getCard(id)
    }
}