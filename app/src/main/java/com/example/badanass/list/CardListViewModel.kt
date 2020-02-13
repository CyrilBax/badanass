package com.example.badanass.list

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.badanass.data.models.Card
import com.example.badanass.domain.profiles.DaggerListViewModule
import com.example.badanass.domain.usecases.GetListUseCase
import com.example.badanass.domain.usecases.RefreshCardList
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject



class CardListViewModel: ViewModel() {

    @Inject
    lateinit var getListCardUseCase: GetListUseCase

    @Inject
    lateinit var refreshCardList: RefreshCardList

    private val subscription: CompositeDisposable = CompositeDisposable()

    private var _cardList = MutableLiveData<List<Card>>()
    val cardList: LiveData<List<Card>>
            get() = _cardList

    private val _errorList = MutableLiveData<Throwable>()
    val errorList: LiveData<Throwable>
        get() = _errorList

    private var _clickDetected = MutableLiveData<String>()
    val clickDetected: LiveData<String>
        get() = _clickDetected

    private val _loadingRefresh = MutableLiveData<Boolean>()
    val loadingRefresh: LiveData<Boolean>
        get() = _loadingRefresh

    init {
        /** Init refresh loader */
        _loadingRefresh.value = false

        /** Init dagger */
        DaggerListViewModule
            .create()
            .inject(this)

        /** Init disposable */
        subscription .addAll(
            getCardList(),
            refreshCardList()
        )
    }

    fun getCardList() : Disposable {
        return getListCardUseCase.execute()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                _cardList.postValue(it)
            }, {
                _errorList.postValue(it)
            })
    }

    fun refreshCardList(): Disposable {
        return refreshCardList.execute()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                _cardList.postValue(it)
            },{
                _errorList.postValue(it)
            })
    }

    fun onCardSelected(card: Card) {
        _clickDetected.value = card.name
    }

    fun onNavigateEnd() {
        _clickDetected.value = null
    }

    fun onRefreshEnd() {
        _loadingRefresh.value  = false
    }

    override fun onCleared() {
        super.onCleared()
        /** Clear disposable */
        subscription.clear()
    }
}