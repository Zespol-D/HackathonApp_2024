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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.hackathonapp2024.viewModel.InspectionViewModel

@Composable
fun InspectionResultScreen(
    navController: NavHostController,
    inspectionViewModel: InspectionViewModel,
) {
    val inspection by inspectionViewModel.inspection.collectAsState()

    var pobranoProbki by remember { mutableStateOf(inspection.pobranoProbki) }
    var wynik by remember { mutableStateOf(inspection.wynik ?: "") }
    var nrProbki by remember { mutableIntStateOf(inspection.nrProbki ?: 0) }
    var wilgDrewna by remember { mutableStateOf(inspection.wilgDrewna ?: "") }
    var poArt191 by remember { mutableStateOf(inspection.poArt191) }
    var poArt334 by remember { mutableStateOf(inspection.poArt334) }
    var czynArt191 by remember { mutableStateOf(inspection.czynArt191) }
    var czynArt334 by remember { mutableStateOf(inspection.czynArt334) }
    var sankcjeKarneEnabled by remember { mutableStateOf(false) }
    var manArt191Liczba by remember { mutableIntStateOf(inspection.manArt191Liczba) }
    var manArt191Kwota by remember { mutableFloatStateOf(inspection.manArt191Kwota) }
    var manArt334Liczba by remember { mutableIntStateOf(inspection.manArt334Liczba) }
    var manArt334Kwota by remember { mutableFloatStateOf(inspection.manArt334Kwota) }

    val scrollState = rememberScrollState()

    BoxWithConstraints {
        if (maxWidth < 600.dp) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(scrollState),
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
                    Text(text = "Wyniki kontroli", fontSize = 25.sp)
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Row(
                        modifier = Modifier
                            .weight(0.8f)
                            .padding(top = 18.dp)
                            .padding(start = 15.dp)
                            .height(20.dp)
                    ) {
                        Text(text = "Pobrano próbki z pieca")
                    }
                    Row(
                        modifier = Modifier
                            .weight(0.1f)
                            .padding(top = 18.dp)
                            .padding(end = 15.dp)
                            .height(20.dp)
                    ) {
                        Checkbox(
                            checked = pobranoProbki,
                            onCheckedChange = { isChecked ->
                                pobranoProbki = isChecked
                            }
                        )
                    }
                }
                Spacer(
                    modifier = Modifier
                        .height(10.dp)
                        .fillMaxWidth()
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                ) {
                    Column(
                        modifier = Modifier
                            .weight(0.05f)
                            .padding(horizontal = 15.dp)
                    ) {
                        Text(text = "Wynik")
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
                    ) {
                        OutlinedTextField(
                            modifier = Modifier
                                .fillMaxWidth(),
                            value = wynik,
                            onValueChange = { wynik = it }
                        )
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
                        .padding(horizontal = 15.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .weight(0.05f)
                    ) {
                        Text(text = "Nr. próbki")
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
                    ) {
                        OutlinedTextField(
                            modifier = Modifier
                                .fillMaxWidth(),
                            value = nrProbki.toString(),
                            onValueChange = { nrProbki = it.toIntOrNull() ?: 0 }
                        )
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
                            .weight(0.05f)
                            .padding(horizontal = 15.dp)
                    ) {
                        Text(text = "Wilgotność drewna powyżej 20%")
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
                        .padding(horizontal = 15.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .weight(0.1f)
                    ) {
                        OutlinedTextField(
                            modifier = Modifier
                                .fillMaxWidth(),
                            value = wilgDrewna,
                            onValueChange = { wilgDrewna = it }
                        )
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
                    Row(
                        modifier = Modifier
                            .weight(0.8f)
                            .padding(top = 18.dp)
                            .padding(start = 15.dp)
                            .height(20.dp)
                    ) {
                        Text(text = "Sankcje karne")
                    }
                    Row(
                        modifier = Modifier
                            .weight(0.1f)
                            .padding(top = 18.dp)
                            .padding(end = 15.dp)
                            .height(20.dp)
                    ) {
                        Checkbox(
                            checked = sankcjeKarneEnabled,
                            onCheckedChange = { isChecked ->
                                sankcjeKarneEnabled = isChecked
                                if (!isChecked) {
                                    poArt191 = false
                                    poArt334 = false
                                    czynArt191 = false
                                    czynArt334 = false
                                    poArt191 = false
                                    poArt334 = false
                                    czynArt191 = false
                                    czynArt334 = false

                                    manArt191Liczba = 0
                                    manArt191Kwota = 0f
                                    manArt334Liczba = 0
                                    manArt334Kwota = 0f
                                }
                            }
                        )
                    }
                }
                Spacer(
                    modifier = Modifier
                        .height(10.dp)
                        .fillMaxWidth()
                )
                HorizontalDivider()
                Spacer(
                    modifier = Modifier
                        .height(10.dp)
                        .fillMaxWidth()
                )
                Text(text = "Pouczenie")
                Spacer(
                    modifier = Modifier
                        .height(10.dp)
                        .fillMaxWidth()
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Row(
                        modifier = Modifier
                            .weight(0.8f)
                            .padding(top = 18.dp)
                            .padding(start = 15.dp)
                            .height(20.dp)
                    ) {
                        Text(text = "atr. 191 Ustawy o odpadach")
                    }
                    Row(
                        modifier = Modifier
                            .weight(0.1f)
                            .padding(top = 18.dp)
                            .padding(end = 15.dp)
                            .height(20.dp)
                    ) {
                        Checkbox(
                            checked = poArt191,
                            onCheckedChange = { isChecked ->
                                if (sankcjeKarneEnabled) {
                                    poArt191 = isChecked
                                    inspectionViewModel.updatePoArt191(isChecked)
                                }
                            },
                            enabled = sankcjeKarneEnabled
                        )
                    }
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Row(
                        modifier = Modifier
                            .weight(0.8f)
                            .padding(top = 18.dp)
                            .padding(start = 15.dp)
                            .height(20.dp)
                    ) {
                        Text(text = "atr. 334 Ustawy Prawo ochrony środowiska")
                    }
                    Row(
                        modifier = Modifier
                            .weight(0.1f)
                            .padding(top = 18.dp)
                            .padding(end = 15.dp)
                            .height(20.dp)
                    ) {
                        Checkbox(
                            checked = poArt334,
                            onCheckedChange = { isChecked ->
                                if (sankcjeKarneEnabled) {
                                    poArt334 = isChecked
                                    inspectionViewModel.updatePoArt334(isChecked)
                                }
                            },
                            enabled = sankcjeKarneEnabled
                        )
                    }
                }
                Spacer(
                    modifier = Modifier
                        .height(10.dp)
                        .fillMaxWidth()
                )
                HorizontalDivider()
                Spacer(
                    modifier = Modifier
                        .height(10.dp)
                        .fillMaxWidth()
                )
                Text(text = "Czynności wyjaśniające")
                Spacer(
                    modifier = Modifier
                        .height(10.dp)
                        .fillMaxWidth()
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Row(
                        modifier = Modifier
                            .weight(0.8f)
                            .padding(top = 18.dp)
                            .padding(start = 15.dp)
                            .height(20.dp)
                    ) {
                        Text(text = "atr. 191 Ustawy o odpadach")
                    }
                    Row(
                        modifier = Modifier
                            .weight(0.1f)
                            .padding(top = 18.dp)
                            .padding(end = 15.dp)
                            .height(20.dp)
                    ) {
                        Checkbox(
                            checked = czynArt191,
                            onCheckedChange = { isChecked ->
                                if (sankcjeKarneEnabled) {
                                    czynArt191 = isChecked
                                    inspectionViewModel.updateCzynArt191(isChecked)
                                }
                            },
                            enabled = sankcjeKarneEnabled
                        )
                    }
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Row(
                        modifier = Modifier
                            .weight(0.8f)
                            .padding(top = 18.dp)
                            .padding(start = 15.dp)
                            .height(20.dp)
                    ) {
                        Text(text = "atr. 334 Ustawy Prawo ochrony środowiska")
                    }
                    Row(
                        modifier = Modifier
                            .weight(0.1f)
                            .padding(top = 18.dp)
                            .padding(end = 15.dp)
                            .height(20.dp)
                    ) {
                        Checkbox(
                            checked = czynArt334,
                            onCheckedChange = { isChecked ->
                                if (sankcjeKarneEnabled) {
                                    czynArt334 = isChecked
                                    inspectionViewModel.updateCzynArt334(isChecked)
                                }
                            },
                            enabled = sankcjeKarneEnabled
                        )
                    }
                }
                Spacer(
                    modifier = Modifier
                        .height(10.dp)
                        .fillMaxWidth()
                )
                HorizontalDivider()
                Spacer(
                    modifier = Modifier
                        .height(10.dp)
                        .fillMaxWidth()
                )
                Text(text = "Mandat karny")
                Spacer(
                    modifier = Modifier
                        .height(10.dp)
                        .fillMaxWidth()
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 15.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .weight(0.05f)
                    ) {
                        Text(text = "Art. 191 - Liczba mandatów")
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
                        ) {
                            OutlinedTextField(
                                modifier = Modifier
                                    .fillMaxWidth(),
                                value = manArt191Liczba.toString(),
                                onValueChange = { manArt191Liczba = it.toIntOrNull() ?: 0 },
                                enabled = sankcjeKarneEnabled
                            )
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
                        .padding(horizontal = 15.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .weight(0.05f)
                    ) {
                        Text(text = "Art. 191 - Kwota mandatu")
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
                    ) {
                        OutlinedTextField(
                            modifier = Modifier
                                .fillMaxWidth(),
                            value = manArt191Kwota.toString(),
                            onValueChange = { manArt191Kwota = it.toFloatOrNull() ?: 0f },
                            enabled = sankcjeKarneEnabled
                        )
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
                        .padding(horizontal = 15.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .weight(0.05f)
                    ) {
                        Text(text = "Art. 334 - Liczba mandatów")
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
                    ) {
                        OutlinedTextField(
                            modifier = Modifier
                            .fillMaxWidth(),
                            value = manArt334Liczba.toString(),
                            onValueChange = { manArt334Liczba = it.toIntOrNull() ?: 0 },
                            enabled = sankcjeKarneEnabled
                        )
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
                        .padding(horizontal = 15.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .weight(0.05f)
                    ) {
                        Text(text = "Art. 334 - Kwota mandatu")
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
                    ) {
                        OutlinedTextField(
                            modifier = Modifier
                                .fillMaxWidth(),
                            value = manArt334Kwota.toString(),
                            onValueChange = { manArt334Kwota = it.toFloatOrNull() ?: 0f },
                            enabled = sankcjeKarneEnabled
                        )
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
                        .padding(top = 18.dp)
                        .padding(end = 25.dp)
                        .padding(bottom = 18.dp),
                    horizontalArrangement = Arrangement.End,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Button(onClick = {
                        inspectionViewModel.updateWynikiKontroli(
                            pobranoProbki = pobranoProbki,
                            wynik = wynik,
                            nrProbki = nrProbki,
                            wilgDrewna = wilgDrewna
                        )
                        inspectionViewModel.updateSankcje(
                            poArt191 = poArt191,
                            poArt334 = poArt334,
                            manArt191Liczba = manArt191Liczba,
                            manArt191Kwota = manArt191Kwota,
                            manArt334Liczba = manArt334Liczba,
                            manArt334Kwota = manArt334Kwota,
                            czynArt191 = czynArt191,
                            czynArt334 = czynArt334
                        )
                        println(inspectionViewModel.inspection.value.poArt334)
                        println(inspectionViewModel.inspection.value.czynArt334)
                        println(inspectionViewModel.inspection.value.manArt334Liczba)
                    }) {
                        Text(text = "Dalej")
                    }
                }
            }
        }
        else if(maxWidth > 600.dp){

        }
    }
}
