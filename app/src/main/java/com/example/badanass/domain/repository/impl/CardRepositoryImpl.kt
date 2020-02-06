package com.example.badanass.domain.repository.impl

import com.example.badanass.data.dataSource.local.LocalDataSource
import com.example.badanass.data.dataSource.remote.RemoteDataSource
import com.example.badanass.data.models.Card
import com.example.badanass.domain.repository.CardRepository
import io.reactivex.Observable

class CardRepositoryImpl(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource
): CardRepository {

    override fun getList(): Observable<List<Card>> {
        /*return localDataSource.getCardList()
            .switchIfEmpty(remoteDataSource.getCardList()
                .doOnNext{localDataSource.saveCard(it)})*/
        return remoteDataSource.getCardList()
    }

    override fun getCard(id: String): Card? {
        return remoteDataSource.getCard(id)
    }
}