package com.example.hackathonapp2024.data

import kotlinx.serialization.Serializable

@Serializable
data class Adres(
    var Miasto: String? = "",
    var Ulica: String? = "",
    var Nr_budynku: String? = "",
    var Nr_lokalu: Int? = 0
)

@Serializable
data class AdresJson(
    val id: String,
    val values: Adres
)


