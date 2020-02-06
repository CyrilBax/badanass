package com.example.badanass.network

import com.example.badanass.data.models.Card
import com.example.badanass.data.models.CardRemote
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import java.util.*

private const val BASE_URL = "https://omgvamp-hearthstone-v1.p.rapidapi.com//"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi).asLenient())
    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
    .baseUrl(BASE_URL)
    .build()

/**
 * A retrofit service to fetch a devbyte playlist.
 */
interface CardService {

    @Headers(
        "X-RapidAPI-Host: omgvamp-hearthstone-v1.p.rapidapi.com",
        "X-RapidAPI-Key: b6a297fa95msh05cccf9b41ba2e3p1c35bejsn5254915cacbd"
    )

    @GET("cards")
    fun getCards(): Observable<CardRemote>
}

/**
 * Main entry point for network access. Call like `DevByteNetwork.devbytes.getPlaylist()`
 */
object CardNetwork {

    val cardService : CardService by lazy {
        retrofit.create(CardService::class.java)
    }

}
