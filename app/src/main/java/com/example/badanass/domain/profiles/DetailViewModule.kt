package com.example.badanass.domain.profiles

import com.example.badanass.detail.CardDetailViewModel
import com.example.badanass.domain.profiles.useCaseModule.UseCaseModule
import dagger.Component

@Component(modules = [UseCaseModule::class])
interface DetailViewModule {
    fun inject(app: CardDetailViewModel)
}