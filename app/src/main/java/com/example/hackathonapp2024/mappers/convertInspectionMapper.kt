import com.example.hackathonapp2024.data.Adres
import com.example.hackathonapp2024.data.AdresJson
import com.example.hackathonapp2024.data.Inspection
import com.example.hackathonapp2024.data.InspectionJson
import com.example.hackathonapp2024.data.InspectionRequestEditJson
import com.example.hackathonapp2024.data.InspectionRequestJson
import com.example.hackathonapp2024.data.RequestInspection
import com.example.hackathonapp2024.data.RequestValues
import com.example.hackathonapp2024.data.RequestValuesEdit
import com.example.hackathonapp2024.data.Values

fun mapInspectionToJson(inspection: Inspection): InspectionJson {
    return InspectionJson(
        id = "2",
        values = Values(
            ID = inspection.id.toString(),
            Miasto = inspection.miasto ?: "n",
            Ulica = inspection.ulica ?: "n",
            Nr_budynku = inspection.nrBudynku ?: "n",
            Nr_lokalu = inspection.nrLokalu ?: "n",
            Typ_lokalu = inspection.typLokalu ?: "n",
            Statut_kontrolowanego = inspection.statutKontrolowanego ?: "n",
            Imie = inspection.imie ?: "n",
            Nazwisko = inspection.nazwisko ?: "n",
            Obiekt_kontroli = inspection.obiektKontroli ?: "n",
            Typ_paliwa = inspection.typPaliwa ?: "n",
            Pobrano_probki = if (inspection.pobranoProbki) "Tak" else "Nie",
            Wynik = inspection.wynik ?: "n",
            Nr_probki = inspection.nrProbki?.toString() ?: "n",
            Wilg_drewna = inspection.wilgDrewna?.toIntOrNull(),
            Liczba_kontroli = inspection.liczbaKontroli ?: 0,
            Po_Art191 = if (inspection.poArt191) 1 else 0,
            Po_Art334 = if (inspection.poArt334) 1 else 0,
            Man_Art191_liczba = inspection.manArt191Liczba,
            Man_Art191_kwota = inspection.manArt191Kwota,
            Man_Art334_liczba = inspection.manArt334Liczba,
            Man_Art334_kwota = inspection.manArt334Kwota,
            Czyn_Art191 = if (inspection.czynArt191) "Tak" else "Nie",
            Czyn_Art334 = if (inspection.czynArt334) "Tak" else "Nie"
        )
    )
}

fun mapRequestInspectionToJson(requestInspection: RequestInspection): InspectionRequestJson {
    return InspectionRequestJson(
        id = "4",
        values = RequestValues(
            Miasto = requestInspection.miasto ?: "n",
            Ulica = requestInspection.ulica ?: "n",
            Nr_budynku = requestInspection.nrBudynku ?: "n",
            Nr_lokalu = requestInspection.nrLokalu ?: 0,
            Imie = requestInspection.imie ?: "n",
            Nazwisko = requestInspection.nazwisko ?: "n",
            Powierzchnia = requestInspection.powierzchnia ?: 0.0f,
            Typ_lokalu = requestInspection.typLokalu ?: "n",
            Piec = requestInspection.piec ?: "n",
            Rok_pieca = requestInspection.rokPieca ?: 0,
            Typ_paliwa = requestInspection.typPaliwa ?: "n",
            Ilosc_paliwa = requestInspection.iloscPaliwa ?: 0.0f,
            Czy_uzysk_dot = requestInspection.czyUzyskDot ?: 0
        )
    )
}

fun mapRequestInspectionToEditJson(requestInspection: RequestInspection): InspectionRequestEditJson {
    return InspectionRequestEditJson(
        id = "5",
        values = RequestValuesEdit(
            Powierzchnia = requestInspection.powierzchnia?.toString() ?: "0.0",
            Typ_lokalu = requestInspection.typLokalu ?: "n",
            Piec = requestInspection.piec ?: "n",
            Rok_pieca = requestInspection.rokPieca ?: 0,
            Ilosc_paliwa = requestInspection.iloscPaliwa?.toFloat() ?: 0.0f,
            Czy_uzysk_dot = requestInspection.czyUzyskDot ?: 0,
            Miasto = requestInspection.miasto ?: "n",
            Ulica = requestInspection.ulica ?: "n",
            Nr_budynku = requestInspection.nrBudynku ?: "n",
            Nr_lokalu = requestInspection.nrLokalu ?: 0
        )
    )
}

fun mapAdresRequestToJson(adres: Adres): AdresJson{
    return AdresJson(
        id = "1",
        values = Adres(
            Miasto = adres.Miasto,
            Ulica = adres.Ulica,
            Nr_budynku = adres.Nr_budynku,
            Nr_lokalu = adres.Nr_lokalu
        )
    )
}


