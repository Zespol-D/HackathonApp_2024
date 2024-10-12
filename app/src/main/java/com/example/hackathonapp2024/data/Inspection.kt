package com.example.hackathonapp2024.data

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

