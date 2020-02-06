package com.example.badanass.data.dataSource.remote

import com.example.badanass.data.models.Card
import io.reactivex.Observable

interface RemoteDataSource {

    fun getCardList(): Observable<List<Card>>

    fun getCard(id: String): Card?
}