package com.example.badanass.data.dataSource.local

import com.example.badanass.data.models.Card
import io.reactivex.Maybe
import io.reactivex.Observable
import io.reactivex.Single

interface LocalDataSource {

    fun getCardList(): Observable<List<Card>>

    fun getCard(name: String): Observable<Card>

    fun saveCard(cards: List<Card>)
}