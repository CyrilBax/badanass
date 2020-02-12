package com.example.badanass.data.dataSource.remote

import android.util.Log
import com.example.badanass.data.models.Card
import com.example.badanass.network.CardNetwork
import io.reactivex.Observable

class RemoteDataSourceImpl: RemoteDataSource {

    override fun getCardList(): Observable<List<Card>> {
        Log.i("remote", "get remote")
        return CardNetwork.cardService.getCards().map {it.Basic}
    }

    override fun getCard(name: String): Observable<Card> {
        return CardNetwork.cardService.getCard(name)
    }
}