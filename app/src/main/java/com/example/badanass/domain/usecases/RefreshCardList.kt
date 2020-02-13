package com.example.badanass.domain.usecases

import com.example.badanass.data.models.Card
import com.example.badanass.domain.repository.CardRepository
import io.reactivex.Observable

class RefreshCardList( private val repository: CardRepository) {

    fun execute(): Observable<List<Card>> {
        return repository.refreshCardList()
    }
}