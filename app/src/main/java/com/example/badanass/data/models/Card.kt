package com.example.badanass.data.models

data class Card(
    val cardId: String,
    val name: String,
    val img: String? = null
)

data class CardRemote(
    val Basic: List<Card>,
    val Classic: List<Card>
)