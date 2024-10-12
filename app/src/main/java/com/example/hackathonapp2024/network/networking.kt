package com.example.hackathonapp2024.network

import android.util.Log
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.hackathonapp2024.data.DataModel
import com.example.hackathonapp2024.data.Inspection
import com.example.hackathonapp2024.viewModel.InspectionViewModel
import kotlinx.coroutines.withTimeoutOrNull
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.jsonObject
import mapInspectionToJson
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.net.HttpURLConnection
import java.net.URL

suspend fun networking(
    inspectionsViewModel: InspectionViewModel,
    uuidString: String,
    responseDecoded: (String) -> Unit
): Pair<Boolean, Boolean> {
    var rcSuccess = false
    var dbSuccess = false

    val jsonData = Json.encodeToString(
        DataModel(
            id = "2",
        )
    )

    val json3 = """{
        "id": "2",
        "values": {
        "Miasto": "Warszawa",
        "Ulica": "Krakowska",
        "Nr_budynku": "123",
        "Nr_lokalu": "4A",
        "Typ_lokalu": "Mieszkalny",
        "Statut_kontrolowanego": "Właściciel",
        "Imie": "Jan",
        "Nazwisko": "Kowalski",
        "Obiekt_kontroli": "Dom jednorodzinny",
        "Typ_paliwa": "Drewno",
        "Pobrano_probki": "Tak",
        "Wynik": "Negatywny",
        "Nr_probki": "56789",
        "Wilg_drewna": "12.5",
        "Liczba_kontroli": 3,
        "Po_Art191": 1,
        "Po_Art334": 0,
        "Man_Art191_liczba": 2,
        "Man_Art191_kwota": 1500.50,
        "Man_Art334_liczba": 0,
        "Man_Art334_kwota": 0.00,
        "Czyn_Art191": 1,
        "Czyn_Art334": 0
    }
    }"""

    var tempJson : String = Json.encodeToString(mapInspectionToJson(inspectionsViewModel.inspection.value))
    Log.d("JSON", tempJson)



    val url = URL("https://hackathon.propages.pl")

    val result = withTimeoutOrNull(10000) {
        with(url.openConnection() as HttpURLConnection) {
            requestMethod = "POST"
            setRequestProperty("Content-Type", "application/json") // Ustawienie nagłówka Content-Type
            doOutput = true
            val wr = OutputStreamWriter(outputStream)
            wr.write(tempJson)
            wr.flush()

            println("URL : $url")
            println("Response Code : $responseCode")

            // Obsługa odpowiedzi serwera
            val responseCode = responseCode
            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Jeśli odpowiedź serwera jest OK (200)
                BufferedReader(InputStreamReader(inputStream)).use {
                    val sb = StringBuffer()

                    var inputLine = it.readLine()
                    while (inputLine != null) {
                        sb.append(inputLine)
                        inputLine = it.readLine()
                    }
                    val response = sb.toString()



                    // Obiekt JSON
                    val json: Map<String, JsonElement> = Json.parseToJsonElement(response).jsonObject
                    responseDecoded(json.toString())
                    rcSuccess = json["rcSuccess"].toString().toBoolean()
                    dbSuccess = json["dbSuccess"].toString().toBoolean()
                    println("${json.entries}")
                }
            } else {
                // Obsługa innych kodów odpowiedzi
                println("Błąd serwera. Kod odpowiedzi: $responseCode")
            }
        }
    }
    if (result == null) {
        println("Przekroczono czas oczekiwania na odpowiedź z serwera")
        rcSuccess = false
        dbSuccess = false
    }
    return Pair(rcSuccess, dbSuccess)
}
