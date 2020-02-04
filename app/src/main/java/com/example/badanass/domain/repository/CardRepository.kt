package com.example.badanass.domain.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.badanass.data.dataSrouce.CardDatabse
import com.example.badanass.data.dataSrouce.asDomainModel
import com.example.badanass.data.models.Card
import com.example.badanass.network.CardNetwork
import com.example.badanass.network.asDatabaseModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.withContext

interface CardRepository {

    /*val cards: LiveData<List<Card>> = Transformations.map(database.cardDao.getAllCard()) {
        it.asDomainModel()
    }

    suspend fun refreshVideos() {
        withContext(Dispatchers.IO) {
            val card = CardNetwork.devcard.getCrads().await()
            database.cardDao.insert(card.asDatabaseModel())
        }
    }*/

    fun getList(): LiveData<List<Card>>

    fun getCard(): LiveData<Card>
}