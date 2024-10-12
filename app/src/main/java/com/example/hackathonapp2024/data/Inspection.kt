package com.example.hackathonapp2024.data

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

