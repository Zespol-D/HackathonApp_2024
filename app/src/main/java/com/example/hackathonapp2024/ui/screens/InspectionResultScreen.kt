package com.example.hackathonapp2024.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Checkbox
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.hackathonapp2024.viewModel.InspectionViewModel

@Composable
fun InspectionResultScreen(
    navController: NavHostController,
    inspectionViewModel: InspectionViewModel,
){
    val inspection by inspectionViewModel.inspection.collectAsState()

    var pobranoProbki by remember { mutableStateOf(inspection.pobranoProbki) }
    var wynik by remember { mutableStateOf(inspection.wynik ?: "") }
    var nrProbki by remember { mutableIntStateOf(inspection.nrProbki ?: 0) }
    var wilgDrewna by remember { mutableStateOf(inspection.wilgDrewna ?: "") }

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(text = "Pobrano próbki z pieca")
            Spacer(
                modifier = Modifier
                    .width(120.dp)
            )
            Checkbox(
                checked = pobranoProbki,
                onCheckedChange = { isChecked ->
                    pobranoProbki = isChecked
                }
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth(),
        ) {
            Column(
                modifier = Modifier
                    .weight(0.05f)
                    .padding(horizontal = 10.dp)
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
                    .padding(horizontal = 10.dp)
            ) {
                OutlinedTextField(
                    value = wynik,
                    onValueChange = { wynik = it }
                )
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp)
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
            ) {
                OutlinedTextField(
                    value = nrProbki.toString(),
                    onValueChange = { nrProbki = it.length }
                )
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Column(
                modifier = Modifier
                    .weight(0.05f)
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
        ) {
            Column(
                modifier = Modifier
                    .weight(0.1f)
            ) {
                OutlinedTextField(
                    value = wilgDrewna,
                    onValueChange = { wilgDrewna = it }
                )
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(text = "Sankcje karne")
            Spacer(
                modifier = Modifier
                .width(120.dp)
            )
            Checkbox(
                checked = inspection.poArt191,
                onCheckedChange = { isChecked ->
                    inspectionViewModel.updatePoArt191(isChecked)
                }
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.CenterVertically
        ) {
            OutlinedButton(onClick = {
               inspectionViewModel.updateWynikiKontroli(
                   pobranoProbki = pobranoProbki,
                   wynik = wynik,
                   nrProbki = nrProbki,
                   wilgDrewna = wilgDrewna
               )
                println(inspectionViewModel.inspection.value.miasto)
                println(inspectionViewModel.inspection.value.statutKontrolowanego)
                println(inspectionViewModel.inspection.value.typPaliwa)
                println(inspectionViewModel.inspection.value.obiektKontroli)
                println(inspectionViewModel.inspection.value.pobranoProbki)
            }) {
                Text(text = "Dalej")
            }
        }

    }

}