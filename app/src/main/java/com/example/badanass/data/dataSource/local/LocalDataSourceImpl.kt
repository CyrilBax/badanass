package com.example.badanass.data.dataSource.local

import com.example.badanass.data.dataSource.CardDatabse
import com.example.badanass.data.dataSource.DatabaseCard
import com.example.badanass.data.models.Card
import io.reactivex.Observable
import io.reactivex.rxkotlin.toObservable

class LocalDataSourceImpl(private val dataBase: CardDatabse): LocalDataSource {

    private val allCard = listOf(
        Card("e", "first", "", ""),
        Card("ee", "two", "", "")
    )

    override fun getCardList(): Observable<List<Card>> {
        // Send an object like an observable
        return Observable.fromCallable {
            dataBase.cardDao.getAllCard().map {
                Card(
                    cardId = it.cardId,
                    name = it.name,
                    type = it.type,
                    img = it.img
                )
            }
        }
    }

    override fun getCard(id: String): Card {
        return allCard[0]
    }

    override fun saveCard(cards: List<Card>) {
        dataBase.cardDao.insert(cards.map {
            DatabaseCard(
                cardId = it.cardId,
                name = it.name,
                type = it.type,
                img = it.img
            )
        })
    }
}