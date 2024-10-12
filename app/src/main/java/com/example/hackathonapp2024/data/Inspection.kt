package com.example.hackathonapp2024.data

import kotlinx.serialization.Serializable

@Serializable
data class Inspection(
    var id: Int = 0,
    var miasto: String? = null,
    var ulica: String? = null,
    var nrBudynku: String? = null,
    var nrLokalu: String? = null,
    var typLokalu: String? = null,
    var statutKontrolowanego: String? = null,
    var imie: String? = null,
    var nazwisko: String? = null,
    var obiektKontroli: String? = null,
    var typPaliwa: String? = null,
    var pobranoProbki: Boolean = false,
    var wynik: String? = null,
    var nrProbki: Int? = null,
    var wilgDrewna: String? = null,
    var liczbaKontroli: Int = 0,
    var poArt191: Boolean = false,
    var poArt334: Boolean = false,
    var manArt191Liczba: Int = 0,
    var manArt191Kwota: Float = 0f,
    var manArt334Liczba: Int = 0,
    var manArt334Kwota: Float = 0f,
    var czynArt191: Boolean = false,
    var czynArt334: Boolean = false,
    var dataKontroli: String? = null,
    var godzinaKontroli: String? = null
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

