package com.example.hackathonapp2024.data

import kotlinx.serialization.Serializable

@Serializable
data class RequestInspection(
    var miasto: String? = null,
    var ulica: String? = null,
    var nrBudynku: String? = null,
    var nrLokalu: Int? = 0,
    var imie: String? = null,
    var nazwisko: String? = null,
    var powierzchnia: Float? = 0.0f,
    var typLokalu: String? = null,
    var piec: String? = null,
    var rokPieca: Int? = 0,
    var typPaliwa: String? = null,
    var iloscPaliwa: Float? = 0.0f,
    var czyUzyskDot: Int? = 0,
)

@Serializable
data class InspectionRequestJson(
    val id: String,
    val values: RequestValues
)

@Serializable
data class RequestValues(
    var Miasto: String,
    var Ulica: String,
    var Nr_budynku: String,
    var Nr_lokalu: Int,
    var Imie: String,
    var Nazwisko: String,
    var Powierzchnia: Float,
    var Typ_lokalu: String,
    var Piec: String,
    var Rok_pieca: Int,
    var Typ_paliwa: String,
    var Ilosc_paliwa: Float,
    var Czy_uzysk_dot: Int
)

@Serializable
data class InspectionRequestEditJson(
    val id: String,
    val values: RequestValuesEdit
)

@Serializable
data class RequestValuesEdit(
    var Powierzchnia: String,
    var Typ_lokalu: String,
    var Piec: String,
    var Rok_pieca: Int,
    var Ilosc_paliwa: Float,
    var Czy_uzysk_dot: Int,
    var Miasto: String,
    var Ulica: String,
    var Nr_budynku: String,
    var Nr_lokalu: Int

)

@Serializable
data class ResponseAdresy(
    val rcSuccess: Boolean? = null,
    val dbSuccess: Boolean?= null,
    val data: List<Adres>?= null
)