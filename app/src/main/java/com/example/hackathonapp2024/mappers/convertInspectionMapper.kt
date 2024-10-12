import com.example.hackathonapp2024.data.Inspection
import com.example.hackathonapp2024.data.InspectionJson
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
            Liczba_kontroli = inspection.liczbaKontroli,
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
