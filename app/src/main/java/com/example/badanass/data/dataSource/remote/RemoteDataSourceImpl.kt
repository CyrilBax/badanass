package com.example.badanass.data.dataSource.remote

import android.util.Log
import com.example.badanass.data.models.Card
import com.example.badanass.network.CardNetwork
import io.reactivex.Observable

class RemoteDataSourceImpl: RemoteDataSource {

    private val allCard = listOf(
        Card("e", "first", "", ""),
        Card("ee", "two","", "")
    )

    override fun getCardList(): Observable<List<Card>> {
        var info = CardNetwork.cardService.getCards().map { it.Basic }
        return info
    }

    override fun getCard(id: String): Card {
        return allCard[0]
    }
}