package com.example.hackathonapp2024.viewModel

import androidx.lifecycle.ViewModel
import com.example.hackathonapp2024.data.Inspection
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class InspectionViewModel : ViewModel() {

    // Internal MutableStateFlow for the Inspection
    private val _inspection = MutableStateFlow(Inspection())

    // Public immutable StateFlow
    val inspection: StateFlow<Inspection>
        get() = _inspection

    fun updateAdres(
        miasto: String,
        ulica: String,
        nrBudynku: String,
        nrLokalu: String,
        typLokalu: String
    ) {
        _inspection.update {
            it.copy(
                miasto = miasto,
                ulica = ulica,
                nrBudynku = nrBudynku,
                nrLokalu = nrLokalu,
                typLokalu = typLokalu
            )
        }
    }

    fun updateKontrolowany(statutKontrolowanego: String, imie: String, nazwisko: String) {
        _inspection.update {
            it.copy(
                statutKontrolowanego = statutKontrolowanego,
                imie = imie,
                nazwisko = nazwisko
            )
        }
    }

    fun updatePiec(obiektKontroli: String, typPaliwa: String) {
        _inspection.update {
            it.copy(
                obiektKontroli = obiektKontroli,
                typPaliwa = typPaliwa
            )
        }
    }

    fun updateSankcje(
        poArt191: Boolean,
        poArt334: Boolean,
        manArt191Liczba: Int,
        manArt191Kwota: Float,
        manArt334Liczba: Int,
        manArt334Kwota: Float,
        czynArt191: Boolean,
        czynArt334: Boolean
    ) {
        _inspection.update {
            it.copy(
                poArt191 = poArt191,
                poArt334 = poArt334,
                manArt191Liczba = manArt191Liczba,
                manArt191Kwota = manArt191Kwota,
                manArt334Liczba = manArt334Liczba,
                manArt334Kwota = manArt334Kwota,
                czynArt191 = czynArt191,
                czynArt334 = czynArt334


            )
        }
    }

    fun updateTermin(dataKontroli: String, godzinaKontroli: String){
        _inspection.update { it.copy(dataKontroli = dataKontroli, godzinaKontroli = godzinaKontroli) }
    }


    // Function to update the city (miasto)
    fun updateMiasto(miasto: String) {
        _inspection.update { it.copy(miasto = miasto) }
    }

    // Function to update the street (ulica)
    fun updateUlica(ulica: String) {
        _inspection.update { it.copy(ulica = ulica) }
    }

    // Function to update the building number (nrBudynku)
    fun updateNrBudynku(nrBudynku: String) {
        _inspection.update { it.copy(nrBudynku = nrBudynku) }
    }

    // Function to update the apartment number (nrLokalu)
    fun updateNrLokalu(nrLokalu: String) {
        _inspection.update { it.copy(nrLokalu = nrLokalu) }
    }

    // Function to update the type of locale (typLokalu)
    fun updateTypLokalu(typLokalu: String) {
        _inspection.update { it.copy(typLokalu = typLokalu) }
    }

    // Function to update the status (statutKontrolowanego)
    fun updateStatutKontrolowanego(statutKontrolowanego: String) {
        _inspection.update { it.copy(statutKontrolowanego = statutKontrolowanego) }
    }

    // Function to update the first name (imie)
    fun updateImie(imie: String) {
        _inspection.update { it.copy(imie = imie) }
    }

    // Function to update the last name (nazwisko)
    fun updateNazwisko(nazwisko: String) {
        _inspection.update { it.copy(nazwisko = nazwisko) }
    }

    // Function to update whether samples were taken (pobranoProbki)
    fun updatePobranoProbki(pobranoProbki: Boolean) {
        _inspection.update { it.copy(pobranoProbki = pobranoProbki) }
    }

    // Function to update the result (wynik)
    fun updateWynik(wynik: String) {
        _inspection.update { it.copy(wynik = wynik) }
    }

    // Function to update sample number (nrProbki)
    fun updateNrProbki(nrProbki: Int) {
        _inspection.update { it.copy(nrProbki = nrProbki) }
    }

    // Function to update the wood moisture level (wilgDrewna)
    fun updateWilgDrewna(wilgDrewna: String) {
        _inspection.update { it.copy(wilgDrewna = wilgDrewna) }
    }

    // Function to update the number of inspections (liczbaKontroli)
    fun updateLiczbaKontroli(liczbaKontroli: Int) {
        _inspection.update { it.copy(liczbaKontroli = liczbaKontroli) }
    }

    // Function to update Article 191 flag (poArt191)
    fun updatePoArt191(poArt191: Boolean) {
        _inspection.update { it.copy(poArt191 = poArt191) }
    }

    // Function to update Article 334 flag (poArt334)
    fun updatePoArt334(poArt334: Boolean) {
        _inspection.update { it.copy(poArt334 = poArt334) }
    }

    // Function to update number of penalties for Article 191 (manArt191Liczba)
    fun updateManArt191Liczba(manArt191Liczba: Int) {
        _inspection.update { it.copy(manArt191Liczba = manArt191Liczba) }
    }

    // Function to update amount of penalties for Article 191 (manArt191Kwota)
    fun updateManArt191Kwota(manArt191Kwota: Float) {
        _inspection.update { it.copy(manArt191Kwota = manArt191Kwota) }
    }

    // Function to update number of penalties for Article 334 (manArt334Liczba)
    fun updateManArt334Liczba(manArt334Liczba: Int) {
        _inspection.update { it.copy(manArt334Liczba = manArt334Liczba) }
    }

    // Function to update amount of penalties for Article 334 (manArt334Kwota)
    fun updateManArt334Kwota(manArt334Kwota: Float) {
        _inspection.update { it.copy(manArt334Kwota = manArt334Kwota) }
    }

    // Function to update action for Article 191 (czynArt191)
    fun updateCzynArt191(czynArt191: Boolean) {
        _inspection.update { it.copy(czynArt191 = czynArt191) }
    }

    // Function to update action for Article 334 (czynArt334)
    fun updateCzynArt334(czynArt334: Boolean) {
        _inspection.update { it.copy(czynArt334 = czynArt334) }
    }
}
