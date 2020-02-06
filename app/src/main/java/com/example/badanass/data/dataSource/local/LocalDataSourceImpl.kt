package com.example.badanass.data.dataSource.local

import com.example.badanass.data.dataSource.CardDatabse
import com.example.badanass.data.dataSource.DatabaseCard
import com.example.badanass.data.models.Card
import io.reactivex.Observable

class LocalDataSourceImpl(private val dataBasse: CardDatabse): LocalDataSource {

    private val allCard = listOf(
        Card("e", "first", ""),
        Card("ee", "two", "")
    )

    override fun getCardList(): Observable<List<Card>> {
        // Send an object like an observable
        return Observable.just(allCard)
    }

    override fun getCard(id: String): Card {
        return allCard[0]
    }

    override fun saveCard(cards: List<Card>) {
        dataBasse.cardDao.insert(cards.map {
            DatabaseCard(
                cardId = it.cardId,
                name = it.name,
                img = it.img
            )
        })
    }
}