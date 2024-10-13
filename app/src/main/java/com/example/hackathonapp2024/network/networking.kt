package com.example.hackathonapp2024.network

import android.util.Log
import com.example.hackathonapp2024.data.Adres
import com.example.hackathonapp2024.data.DataModel
import com.example.hackathonapp2024.viewModel.InspectionViewModel
import com.example.hackathonapp2024.viewModel.RequestInspectionViewModel
import kotlinx.coroutines.withTimeoutOrNull
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.jsonObject
import mapAdresRequestToJson
import mapInspectionToJson
import mapRequestInspectionToEditJson
import mapRequestInspectionToJson
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.net.HttpURLConnection
import java.net.URL

suspend fun networking(
    inspectionsViewModel: InspectionViewModel,
    requestInspectionViewModel: RequestInspectionViewModel,
    uuidString: String,
    responseDecoded: (String) -> Unit
): Pair<Boolean, Boolean> {
    var rcSuccess = false
    var dbSuccess = false

    var tempJson : String = Json.encodeToString(mapInspectionToJson(inspectionsViewModel.inspection.value))
    Log.d("JSON", tempJson)

    var temp2Json : String = Json.encodeToString(mapRequestInspectionToJson(requestInspectionViewModel.inspection.value))
    Log.d("JSON", temp2Json)

    var temp3Json : String = Json.encodeToString(mapRequestInspectionToEditJson(requestInspection = requestInspectionViewModel.inspection.value))
    Log.d("JSON", temp3Json)
    //var adres = Adres("Warszawka", "Knagi", "69", 1)
    var temp4json = """{"id": "1"}"""
    var dataModel = DataModel(
        id = "1"
    )
    var temp4json2 : String = Json.encodeToString(dataModel)
    Log.d("JSON", temp2Json)


    val url = URL("https://hackathon.propages.pl")

    val result = withTimeoutOrNull(10000) {
        with(url.openConnection() as HttpURLConnection) {
            requestMethod = "POST"
            setRequestProperty("Content-Type", "application/json") // Ustawienie nagłówka Content-Type
            doOutput = true
            val wr = OutputStreamWriter(outputStream)

            wr.write(temp4json2)
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
