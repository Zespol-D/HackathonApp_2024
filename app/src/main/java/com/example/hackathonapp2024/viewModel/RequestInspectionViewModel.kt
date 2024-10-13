package com.example.hackathonapp2024.viewModel

import androidx.lifecycle.ViewModel
import com.example.hackathonapp2024.data.RequestInspection
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class RequestInspectionViewModel : ViewModel() {

    // Internal MutableStateFlow for the Inspection
    private var _requestInspection = MutableStateFlow(RequestInspection())

    // Public immutable StateFlow
    val inspection: StateFlow<RequestInspection>
        get() = _requestInspection


    fun updateAdres(
        miasto: String,
        ulica: String,
        nrBudynku: String,
        nrLokalu: Int,
    ) {
        _requestInspection.update {
            it.copy(
                miasto = miasto,
                ulica = ulica,
                nrBudynku = nrBudynku,
                nrLokalu = nrLokalu
            )
        }
    }

    fun updateOsoba(
        imie: String,
        nazwisko: String,
    ) {
        _requestInspection.update {
            it.copy(
                imie = imie,
                nazwisko = nazwisko
            )
        }
    }

    fun updateMiesz(
        powierzchnia: Float,
        typLokalu: String,
        piec: String,
        rokPieca: Int,
        typPaliwa: String,
        iloscPaliwa: Float,
        czyUzyskDot: Int
    ) {
        _requestInspection.update {
            it.copy(
                powierzchnia = powierzchnia,
                typLokalu = typLokalu,
                piec = piec,
                rokPieca = rokPieca,
                typPaliwa = typPaliwa,
                iloscPaliwa = iloscPaliwa,
                czyUzyskDot = czyUzyskDot

            )
        }
    }

    fun updateForEdit(
        powierzchnia: Float,
        typLokalu: String,
        piec: String,
        rokPieca: Int,
        typPaliwa: String,
        iloscPaliwa: Float,
        czyUzyskDot: Int
    ) {
        _requestInspection.update {
            it.copy(
                powierzchnia = powierzchnia,
                typLokalu = typLokalu,
                piec = piec,
                rokPieca = rokPieca,
                typPaliwa = typPaliwa,
                iloscPaliwa = iloscPaliwa,
                czyUzyskDot = czyUzyskDot
            )
        }
    }
}
