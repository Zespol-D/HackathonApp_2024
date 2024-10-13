package com.example.hackathonapp2024.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.hackathonapp2024.data.Adres
import com.example.hackathonapp2024.data.Inspection
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class AdresViewModel : ViewModel() {

    // Internal MutableStateFlow for the Inspection
    private var _adres = MutableStateFlow(Adres())

    // Public immutable StateFlow
    val inspection: StateFlow<Adres>
        get() = _adres


    fun updateAdres(
        miasto: String?,
        ulica: String?,
        nrBudynku: String?,
        nrLokalu: Int?,
    ) {
        Log.d("InspectionViewModel", "Updating adres with miasto: $miasto")
        _adres.update {
            it.copy(
                Miasto = miasto,
                Ulica = ulica,
                Nr_budynku = nrBudynku,
                Nr_lokalu =  nrLokalu
            )
        }
    }
}