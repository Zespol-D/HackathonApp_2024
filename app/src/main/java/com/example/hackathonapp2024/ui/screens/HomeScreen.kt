package com.example.hackathonapp2024.ui.screens
import com.example.hackathonapp2024.R

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.net.NetworkRequest
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.hackathonapp2024.UUIDManager
import com.example.hackathonapp2024.classes.Navigation
import com.example.hackathonapp2024.data.Adres
import com.example.hackathonapp2024.data.DataModel
import com.example.hackathonapp2024.data.ResponseAdresy
import com.example.hackathonapp2024.network.isNetworkAvailable
import com.example.hackathonapp2024.network.networking
import com.example.hackathonapp2024.viewModel.AdresViewModel
import com.example.hackathonapp2024.viewModel.InspectionViewModel
import com.example.hackathonapp2024.viewModel.RequestInspectionViewModel
import com.google.android.gms.common.api.Response
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

@Composable
fun HomeScreen(
    navController: NavHostController,
    activity: ComponentActivity,
    inspectionViewModel: InspectionViewModel,
    requestInspectionViewModel: RequestInspectionViewModel,
    adresViewModel: AdresViewModel
) {
    var responseDecoded by remember { mutableStateOf("") }
    var elapsedTime by remember { mutableLongStateOf(0L) }
    var networkError by remember { mutableStateOf(false) }
    var rcSuccess by remember { mutableStateOf(false) }
    var dbSuccess by remember { mutableStateOf(false) }
    var classType by remember { mutableStateOf(Adres()) }
    var objectClass by remember { mutableStateOf<ResponseAdresy?>(null) }
    val uuidString = UUIDManager.getUUID()

    // Snackbar
    val scope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }
    var isSnackbarVisible by remember { mutableStateOf(false) }

    // Monitorowanie stanu sieci
    val connectivityManager =
        activity.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

    val networkCallback = remember {
        object : ConnectivityManager.NetworkCallback() {
            override fun onAvailable(network: Network) {
                super.onAvailable(network)

                var dataModel = DataModel(
                    id = "1"
                )
                var json : String = Json.encodeToString(dataModel)
                Log.d("JSON", json)
                scope.launch(Dispatchers.IO) {
                    if (isNetworkAvailable(activity)) {
                        val startTime = System.currentTimeMillis()
                        val (rc, db) = networking(inspectionViewModel, requestInspectionViewModel, uuidString, json) { decodedResponse ->
                            responseDecoded =
                                decodedResponse // Uaktualnienie zmiennej responseDecoded
                        }
                        objectClass = Json.decodeFromString<ResponseAdresy>(responseDecoded)
                        rcSuccess = rc
                        dbSuccess = db

                        networkError = !rc
                        val endTime = System.currentTimeMillis()
                        elapsedTime = endTime - startTime
                        Log.d("Czas wykonania", "Czas wykonania: ${elapsedTime}ms")
                        Log.d("Odbiór danych: ", "Odbiór danych: [$rcSuccess]")
                        Log.d("Zapis danych: ", "Zapis danych: [$dbSuccess]")
                    }
                }
            }

            override fun onLost(network: Network) {
                super.onLost(network)
                scope.launch {
                    networkError = true
                }
            }
        }
    }

    DisposableEffect(Unit) {
        val request = NetworkRequest.Builder()
            .addCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
            .build()

        connectivityManager.registerNetworkCallback(request, networkCallback)

        onDispose {
            connectivityManager.unregisterNetworkCallback(networkCallback)
        }
    }

    LaunchedEffect(Unit) {
        if (!isNetworkAvailable(activity)) {
            networkError = true
        }
    }

    Scaffold(
        snackbarHost = { SnackbarHost(hostState = snackbarHostState) }
    ) { contentPadding ->
        Column(
            modifier = Modifier
                .padding(contentPadding)
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.surface),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text("Response decoded: ")
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Button(
                    modifier = Modifier
                        .width(190.dp),
                    onClick = {
                        navController.navigate(Navigation.AdressScreenForm.route)
                    }
                ) {
                    Text(text = "Przeprowadź kontrolę")
                }


                LazyColumn(
                    modifier = Modifier.fillMaxSize()
                ) {
                    objectClass?.data?.let { adresy ->
                        items(adresy) { adres: Adres ->
                            Log.d("DANE", "${adres.Miasto}  ${adres.Ulica} ${adres.Nr_budynku}  ${adres.Nr_lokalu}")

                            Row(
                                modifier = Modifier
                                    .padding(1.dp)
                                    .fillMaxWidth()
                                    .border(1.dp, Color.Black),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.Center
                            ) {
                                Column(modifier = Modifier.padding(4.dp)
                                    .clickable {
                                        adresViewModel.updateAdres(adres.Miasto, adres.Ulica, adres.Nr_budynku, adres.Nr_lokalu)
                                        navController.navigate(Navigation.AdressScreenForm.route)
                                    }
                                ) {
                                    Row {
                                        Text(text = "Wniosek o inspekcję budynku...")
                                    }
                                    Row {
                                        Text(text = "${adres.Miasto}  ${adres.Ulica} ${adres.Nr_budynku}  ${adres.Nr_lokalu}")
                                    }
                                }
                            }
                        }
                    }
                }

            }




            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
            )



            BoxWithConstraints(
                modifier = Modifier
                    //.weight(0.15f)
                    .fillMaxWidth()
            ) {
                if (maxWidth < 600.dp) {
                    Column(
                        modifier = Modifier
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(text = "Pasek na dole")
                        }
                    }
                } else {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(text = stringResource(R.string.bottmom_belt))
                    }
                }
            }
        }
    }
    LaunchedEffect(networkError) {
        if (networkError && !isSnackbarVisible) {
            isSnackbarVisible = true
            scope.launch {
                val result = snackbarHostState.showSnackbar(
                    message = "Brak połączenia z siecią",
                    actionLabel = "Zamknij"
                )
                if (result == SnackbarResult.ActionPerformed) {
                    networkError = false
                }
                isSnackbarVisible = false
            }
        }
    }
}
