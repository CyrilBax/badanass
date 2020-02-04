package com.example.badanass.domain.usecases

import androidx.lifecycle.LiveData
import com.example.badanass.data.models.Card
import com.example.badanass.domain.repository.CardRepository

class getListUseCase {

    fun execute(): LiveData<List<Card>> {
        return CardRepository.getList()
    }
}