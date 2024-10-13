package com.example.hackathonapp2024.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.hackathonapp2024.classes.Navigation
import com.example.hackathonapp2024.viewModel.AdresViewModel
import com.example.hackathonapp2024.viewModel.InspectionViewModel

@Composable
fun AdressScreenForm(
    navController: NavHostController,
    inspectionViewModel: InspectionViewModel,
    adres: AdresViewModel
) {
    val inspection by inspectionViewModel.inspection.collectAsState()
    val adresA by adres.inspection.collectAsState()

    // Pamiętaj stan lokalnie, ustawiając wartości domyślne na pusty string, jeśli są null
    var miasto by remember { mutableStateOf(inspection.miasto ?: "") }
    var ulica by remember { mutableStateOf(inspection.ulica ?: "") }
    var nrBudynku by remember { mutableStateOf(inspection.nrBudynku ?: "") }
    var nrLokalu by remember { mutableStateOf(inspection.nrLokalu ?: "") }
    var typLokalu by remember { mutableStateOf(inspection.typLokalu ?: "") }

    BoxWithConstraints {
        if (maxWidth < 600.dp) {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 18.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = "Adres", fontSize = 34.sp)
                }
                // Pole Miasto
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(0.05f)
                            .padding(horizontal = 15.dp)
                            .padding(top = 18.dp)
                    ) {
                        Text(text = "Miasto")
                    }
                }
                Spacer(
                    modifier = Modifier
                        .height(10.dp)
                        .fillMaxWidth()
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier
                            .weight(0.1f)
                            .padding(horizontal = 15.dp)
                            .fillMaxWidth()
                    ) {
                        OutlinedTextField(
                            modifier = Modifier
                                .fillMaxWidth(),
                            value = miasto,
                            onValueChange = { miasto = it }
                        )
                    }
                }

                // Pole Ulica
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier
                            .weight(0.05f)
                            .padding(horizontal = 15.dp)
                            .padding(top = 14.dp)
                    ) {
                        Text(text = "Ulica")
                    }
                }
                Spacer(
                    modifier = Modifier
                        .height(10.dp)
                        .fillMaxWidth()
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier
                            .weight(0.1f)
                            .padding(horizontal = 15.dp)
                            .fillMaxWidth()
                    ) {
                        OutlinedTextField(
                            modifier = Modifier
                                .fillMaxWidth(),
                            value = ulica,
                            onValueChange = { ulica = it }
                        )
                    }
                }

                // Pole Nr Budynku
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier
                            .weight(0.05f)
                            .padding(horizontal = 15.dp)
                            .padding(top = 14.dp)
                    ) {
                        Text(text = "Nr. Budynku")
                    }
                }
                Spacer(
                    modifier = Modifier
                        .height(10.dp)
                        .fillMaxWidth()
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier
                            .weight(0.1f)
                            .padding(horizontal = 15.dp)
                            .fillMaxWidth()
                    ) {
                        OutlinedTextField(
                            modifier = Modifier
                                .fillMaxWidth(),
                            value = nrBudynku,
                            onValueChange = { nrBudynku = it }
                        )
                    }
                }

                // Pole Nr Lokalu
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier
                            .weight(0.05f)
                            .padding(horizontal = 15.dp)
                            .padding(top = 14.dp)
                    ) {
                        Text(text = "Nr. Lokalu")
                    }
                }
                Spacer(
                    modifier = Modifier
                        .height(10.dp)
                        .fillMaxWidth()
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier
                            .weight(0.1f)
                            .padding(horizontal = 15.dp)
                            .fillMaxWidth()
                    ) {
                        OutlinedTextField(
                            modifier = Modifier
                                .fillMaxWidth(),
                            value = nrLokalu,
                            onValueChange = { nrLokalu = it }
                        )
                    }
                }

                // Pole Typ Lokalu
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier
                            .weight(0.05f)
                            .padding(horizontal = 15.dp)
                            .padding(top = 14.dp)
                    ) {
                        Text(text = "Typ Lokalu")
                    }
                }
                Spacer(
                    modifier = Modifier
                        .height(10.dp)
                        .fillMaxWidth()
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier
                            .weight(0.1f)
                            .padding(horizontal = 15.dp)
                            .fillMaxWidth()
                    ) {
                        OutlinedTextField(
                            modifier = Modifier
                                .fillMaxWidth(),
                            value = typLokalu,
                            onValueChange = { typLokalu = it }
                        )
                    }
                }

                // Przycisk Dalej
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 18.dp)
                        .padding(end = 15.dp),
                    horizontalArrangement = Arrangement.End,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Button(onClick = {
                        inspectionViewModel.updateAdres(
                            miasto = miasto,
                            ulica = ulica,
                            nrBudynku = nrBudynku,
                            nrLokalu = nrLokalu,
                            typLokalu = typLokalu
                        )
                        navController.navigate(Navigation.ControlledPersonForm.route)
                    }) {
                        Text(text = "Dalej")
                    }
                }
            }
        }
        // Obsługa większych ekranów (tutaj podobna logika)
    }
}