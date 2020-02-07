package com.example.badanass.list

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.badanass.data.models.Card
import com.example.badanass.domain.profiles.DaggerListViewModule
import com.example.badanass.domain.usecases.GetCardUseCase
import com.example.badanass.domain.usecases.GetListUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject



class CardListViewModel: ViewModel() {

    @Inject
    lateinit var getListCardUseCase: GetListUseCase

    private var _cardList = MutableLiveData<List<Card>>()
    val cardList: LiveData<List<Card>>
            get() = _cardList

    private val _errorList = MutableLiveData<Throwable>()
    val errorList: LiveData<Throwable>
        get() = _errorList

    private var _clickDetected = MutableLiveData<String>()
    val clickDetected: LiveData<String>
        get() = _clickDetected

    init {
        DaggerListViewModule
            .create()
            .inject(this)
        getCardList()
    }

    //TODO: DISPOSE
    fun getCardList() {
        getListCardUseCase.execute()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                _cardList.value = it
            }, {
                _errorList.value = it
            })
    }

    fun onCardSelected(card: Card) {
        _clickDetected.value = card.cardId
    }

    fun onNavigateEnd() {
        _clickDetected.value = null
    }
}