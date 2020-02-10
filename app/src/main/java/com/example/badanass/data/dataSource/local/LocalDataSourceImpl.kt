package com.example.badanass.data.dataSource.local

import com.example.badanass.data.dataSource.CardDatabse
import com.example.badanass.data.dataSource.DatabaseCard
import com.example.badanass.data.models.Card
import io.reactivex.Observable

class LocalDataSourceImpl(private val dataBase: CardDatabse) : LocalDataSource {

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

    override fun getCard(name: String): Observable<Card>? {
        return Observable.fromCallable {
            val card = dataBase.cardDao.get(name)
            card?.let {
                Card(
                    cardId = card.cardId,
                    name = card.name,
                    type = card.type,
                    img = card.img
                )
            }
        }

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