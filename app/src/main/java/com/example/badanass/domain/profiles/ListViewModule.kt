package com.example.badanass.domain.profiles

import com.example.badanass.domain.profiles.useCaseModule.UseCaseModule
import com.example.badanass.domain.usecases.GetCardUseCase
import com.example.badanass.list.CardListFragment
import dagger.Component

@Component(modules = [UseCaseModule::class])
interface ListViewModule {
    fun inject(app: CardListFragment)
}