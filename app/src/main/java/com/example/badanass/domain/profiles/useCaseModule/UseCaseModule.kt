package com.example.badanass.domain.profiles.useCaseModule

import com.example.badanass.domain.profiles.CardRepositoryModule
import com.example.badanass.domain.repository.CardRepository
import com.example.badanass.domain.usecases.GetCardUseCase
import com.example.badanass.domain.usecases.GetListUseCase
import dagger.Module
import dagger.Provides

@Module(includes = [CardRepositoryModule::class])
class UseCaseModule {

    @Provides
    fun provideGetListUseCase(repository: CardRepository): GetListUseCase {
        return GetListUseCase(repository)
    }

    @Provides
    fun provideGetCardUseCase(repository: CardRepository): GetCardUseCase {
        return GetCardUseCase(repository)
    }
}
