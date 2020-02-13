package com.example.badanass.data.dataSource.remote

import com.example.badanass.data.models.Card
import com.example.badanass.network.CardNetwork
import io.reactivex.Observable

class RemoteDataSourceImpl: RemoteDataSource {

    /** Get a list of card on netWork */
    override fun getCardList(): Observable<List<Card>> {
        return CardNetwork.cardService.getCards().map {it.Basic}
    }

    /** Get a specific card on netWork */
    override fun getCard(name: String): Observable<Card> {
        return CardNetwork.cardService.getCard(name)
    }
}