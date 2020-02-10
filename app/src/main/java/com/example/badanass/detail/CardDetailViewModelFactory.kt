package com.example.badanass.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

class CardDetailViewModelFactory (
    private val cardId: String
): ViewModelProvider.Factory {

    @Suppress("unchecked_casr")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CardDetailViewModel::class.java)) {
            return CardDetailViewModel(cardId) as T
        }
        throw IllegalArgumentException("Unknow ViewModel class")
    }
}