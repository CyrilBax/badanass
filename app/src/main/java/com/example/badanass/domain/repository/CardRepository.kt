package com.example.badanass.domain.repository

import com.example.badanass.data.models.Card
import io.reactivex.Observable

interface CardRepository {

    fun getList(): Observable<List<Card>>

    fun getCard(name: String): Observable<Card>

    fun refreshCardList(): Observable<List<Card>>
}