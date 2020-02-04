package com.example.badanass.domain.repository.impl

import androidx.lifecycle.LiveData
import com.example.badanass.data.models.Card
import com.example.badanass.domain.repository.CardRepository

class CardRepositoryImpl: CardRepository {

    override fun getList(): LiveData<List<Card>> {

        /*val cards: LiveData<List<Card>> = Transformations.map(database.cardDao.getAllCard()) {
            it.asDomainModel()
        }

        suspend fun refreshVideos() {
            withContext(Dispatchers.IO) {
                val card = CardNetwork.devcard.getCrads().await()
                database.cardDao.insert(card.asDatabaseModel())
            }
        }*/
        //TODO -> remote or local
        return
    }


    override fun getCard(): LiveData<Card> {
        //TODO -> remote or local
        return
    }
}