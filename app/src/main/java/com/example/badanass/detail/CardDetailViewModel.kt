package com.example.badanass.detail

import androidx.lifecycle.ViewModel
import com.example.badanass.domain.usecases.GetCardUseCase
import javax.inject.Inject

class CardDetailViewModel: ViewModel() {
    @Inject
    lateinit var getCardUseCase: GetCardUseCase
}