package com.example.badanass.domain.usecases

import com.example.badanass.data.models.Card
import com.example.badanass.domain.repository.CardRepository
import io.reactivex.Observable

class GetListUseCase(private val repository: CardRepository) {

    fun execute(): Observable<List<Card>> {
        return repository.getList()
    }
}