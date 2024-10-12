package com.example.hackathonapp2024.data

import kotlinx.serialization.Serializable

@Serializable
data class Inspection(
    val id: Int = 0,
    val miasto: String? = null,
    val ulica: String? = null,
    val nrBudynku: String? = null,
    val nrLokalu: String? = null,
    val typLokalu: String? = null,
    val statutKontrolowanego: String? = null,
    val imie: String? = null,
    val nazwisko: String? = null,
    val obiektKontroli: String? = null,
    val typPaliwa: String? = null,
    val pobranoProbki: Boolean = false,
    val wynik: String? = null,
    val nrProbki: Int? = null,
    val wilgDrewna: String? = null,
    val liczbaKontroli: Int = 0,
    val poArt191: Boolean = false,
    val poArt334: Boolean = false,
    val manArt191Liczba: Int = 0,
    val manArt191Kwota: Float = 0f,
    val manArt334Liczba: Int = 0,
    val manArt334Kwota: Float = 0f,
    val czynArt191: Boolean = false,
    val czynArt334: Boolean = false,
    val dataKontroli: String? = null,
    val godzinaKontroli: String? = null
)


@Serializable
data class InspectionJson(
    val id: String,
    val values: Values
)

@Serializable
data class Values(
    val ID: String?,
    val Miasto: String,
    val Ulica: String,
    val Nr_budynku: String,
    val Nr_lokalu: String,
    val Typ_lokalu: String,
    val Statut_kontrolowanego: String,
    val Imie: String,
    val Nazwisko: String,
    val Obiekt_kontroli: String,
    val Typ_paliwa: String,
    val Pobrano_probki: String,
    val Wynik: String,
    val Nr_probki: String?,
    val Wilg_drewna: Int?,
    val Liczba_kontroli: Int,
    val Po_Art191: Int,
    val Po_Art334: Int,
    val Man_Art191_liczba: Int,
    val Man_Art191_kwota: Float,
    val Man_Art334_liczba: Int,
    val Man_Art334_kwota: Float,
    val Czyn_Art191: String,
    val Czyn_Art334: String
)

