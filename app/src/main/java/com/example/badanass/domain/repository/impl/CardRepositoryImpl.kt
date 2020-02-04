package com.example.badanass.domain.repository.impl

import com.example.badanass.data.dataSrouce.LocalDataSource
import com.example.badanass.data.models.Card
import com.example.badanass.domain.repository.CardRepository

class CardRepositoryImpl(private val dataSource: LocalDataSource): CardRepository {

    override fun getList(): List<Card> {

        /*val cards: LiveData<List<Card>> = Transformations.map(database.cardDao.getAllCard()) {
            it.asDomainModel()
        }

        suspend fun refreshVideos() {
            withContext(Dispatchers.IO) {
                val card = CardNetwork.devcard.getCrads().await()
                database.cardDao.insert(card.asDatabaseModel())
            }
        }*/
        //TODO -> remote or local sub on internet connection

        return dataSource.getCardList()
    }


    override fun getCard(id: String): Card? {
        //TODO -> remote or local
        return dataSource.getCard(id)
    }
}