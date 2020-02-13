package com.example.badanass.data.dataSource.local

import com.example.badanass.data.dataSource.CardDatabse
import com.example.badanass.data.dataSource.DatabaseCard
import com.example.badanass.data.models.Card
import io.reactivex.Observable

class LocalDataSourceImpl(private val dataBase: CardDatabse) : LocalDataSource {

    /** Get card list from room dataBase and convert it */
    override fun getCardList(): Observable<List<Card>> {
        return Observable.fromCallable {
            dataBase.cardDao.getAllCard().map {
                Card(
                    cardId = it.cardId,
                    name = it.name,
                    type = it.type,
                    img = it.img
                )
            }
        }.flatMap {
            if (it.size === 0) {
                Observable.empty<List<Card>>()
            } else {
                Observable.just(it)
            }
        }

        /*return dataBase.cardDao.getAllCard().map { card ->
            card.map {
                Card(
                    cardId = it.cardId,
                    name = it.name,
                    type = it.type,
                    img = it.img
                )
            }
        }.flatMap {
            if (it.isEmpty()) {
                Log.i("hellooooo", "THERE")
                Observable.empty<List<Card>>()
            } else {
                Observable.just(it)
            }
        }*/
    }

    /** Get specific card from dataBase and convert it */
    override fun getCard(name: String): Observable<Card> {
        return dataBase.cardDao.get(name)?.map {
            Card(
                cardId = it.cardId,
                name = it.name,
                type = it.type,
                img = it.img
            )
        }?: Observable.empty()
    }

    /** Save a list of card converted into room dataBase */
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