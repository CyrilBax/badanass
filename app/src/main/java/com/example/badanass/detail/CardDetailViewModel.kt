package com.example.badanass.detail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.badanass.data.models.Card
import com.example.badanass.domain.profiles.DaggerDetailViewModule
import com.example.badanass.domain.usecases.GetCardUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.Job
import javax.inject.Inject

class CardDetailViewModel(
    private val name: String
) : ViewModel() {

    @Inject
    lateinit var getCardUseCase: GetCardUseCase

    private val subscription: CompositeDisposable = CompositeDisposable()

    private val _card = MutableLiveData<Card>()
    val card: LiveData<Card>
        get() = _card

    private val _error = MutableLiveData<String>()
    val error: LiveData<String>
        get() = _error

    init {
        DaggerDetailViewModule
            .create()
            .inject(this)
        subscription.add(
            getCardDetails()
        )
    }

    private fun getCardDetails(): Disposable {
        return getCardUseCase.execute(name)
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
        subscription.clear()
    }

}