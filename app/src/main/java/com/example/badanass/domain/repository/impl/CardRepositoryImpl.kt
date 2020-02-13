package com.example.badanass.domain.repository.impl

import com.example.badanass.data.dataSource.local.LocalDataSource
import com.example.badanass.data.dataSource.remote.RemoteDataSource
import com.example.badanass.data.models.Card
import com.example.badanass.domain.repository.CardRepository
import io.reactivex.Observable

class CardRepositoryImpl(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource
) : CardRepository {

    override fun getList(): Observable<List<Card>> {
        return localDataSource.getCardList()
            .switchIfEmpty(remoteDataSource.getCardList()
                .doOnNext {
                    localDataSource.saveCard(it)
                }
            )
    }

    override fun getCard(name: String): Observable<Card> {
        return localDataSource.getCard(name)
            .switchIfEmpty(remoteDataSource.getCard(name)
                .doOnNext {
                    localDataSource.saveCard(listOf(it))
                }
            )
    }

    override fun refreshCardList(): Observable<List<Card>> {
        return remoteDataSource.getCardList()
            .doOnNext {
                localDataSource.saveCard(it)
            }
    }
}