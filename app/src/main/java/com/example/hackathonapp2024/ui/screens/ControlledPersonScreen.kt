package com.example.hackathonapp2024.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedButton
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.hackathonapp2024.classes.Navigation
import com.example.hackathonapp2024.viewModel.InspectionViewModel

@Composable
fun ControlledPersonScreen(
    navController: NavHostController,
    inspectionViewModel: InspectionViewModel,
){
    val inspection by inspectionViewModel.inspection.collectAsState()

    var statutKontrolowanego by remember { mutableStateOf(inspection.statutKontrolowanego ?: "") }
    var imie by remember { mutableStateOf(inspection.imie ?: "") }
    var nazwisko by remember { mutableStateOf(inspection.nazwisko ?: "") }

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
        ) {
            Column(
                modifier = Modifier
                    .weight(0.05f)
                    .padding(horizontal = 10.dp)
            ) {
                Text(text = "Status kontrolowanego")
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
                    value = statutKontrolowanego,
                    onValueChange = { statutKontrolowanego = it }
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
                Text(text = "Imię")
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
                    value = imie,
                    onValueChange = { imie = it }
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
                Text(text = "Nazwisko")
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
                    value = nazwisko,
                    onValueChange = { nazwisko = it }
                )
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.CenterVertically
        ) {
            OutlinedButton(onClick = {
                inspectionViewModel.updateKontrolowany(
                    statutKontrolowanego = statutKontrolowanego,
                    imie = imie,
                    nazwisko = nazwisko
                )
                navController.navigate(Navigation.FurnaceForm.route)
                println(inspectionViewModel.inspection.value.miasto)
                println(inspectionViewModel.inspection.value.statutKontrolowanego)
            }) {
                Text(text = "Dalej")
            }
        }

    }

}