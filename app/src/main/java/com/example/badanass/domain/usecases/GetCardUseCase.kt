package com.example.badanass.domain.usecases

import com.example.badanass.data.models.Card
import com.example.badanass.domain.repository.CardRepository
import io.reactivex.Observable

class GetCardUseCase(private val repository: CardRepository) {

    fun execute(name: String): Observable<Card> {
        return repository.getCard(name)
    }
}