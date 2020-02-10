package com.example.badanass.detail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.badanass.data.models.Card
import com.example.badanass.domain.profiles.DaggerDetailViewModule
import com.example.badanass.domain.usecases.GetCardUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.Job
import javax.inject.Inject

class CardDetailViewModel(
    private val cardId: String
): ViewModel() {

    @Inject
    lateinit var getCardUseCase: GetCardUseCase

    private var viewModelJob = Job()

    private val _card = MutableLiveData<Card>()
    val card: LiveData<Card>
        get()= _card

    private val _error = MutableLiveData<String>()
    val error: LiveData<String>
        get() = _error

    init {
        DaggerDetailViewModule
            .create()
            .inject(this)
        getCardDetails()
    }

    private fun getCardDetails() {
        getCardUseCase.execute(cardId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                _card.value = it
            }, {
                _error.value = it.toString()
            })
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

}