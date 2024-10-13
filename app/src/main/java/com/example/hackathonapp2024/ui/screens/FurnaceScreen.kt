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
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.hackathonapp2024.classes.Navigation
import com.example.hackathonapp2024.viewModel.InspectionViewModel

@Composable
fun FurnaceScreen(
    navController: NavHostController,
    inspectionViewModel: InspectionViewModel,
){
    val inspection by inspectionViewModel.inspection.collectAsState()

    var obiektKontroli by remember { mutableStateOf(inspection.obiektKontroli ?: "") }
    var typPaliwa by remember { mutableStateOf(inspection.typPaliwa ?: "") }

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
                    Text(text = "Dane kontrolowanego obiektu", fontSize = 25.sp)
                }
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
                        Text(text = "Obiekt kontroli")
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
                            value = obiektKontroli,
                            onValueChange = { obiektKontroli = it }
                        )
                    }
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(0.05f)
                            .padding(horizontal = 15.dp)
                            .padding(top = 18.dp)
                    ) {
                        Text(text = "Typ paliwa")
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
                            value = typPaliwa,
                            onValueChange = { typPaliwa = it }
                        )
                    }
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 18.dp)
                        .padding(end = 15.dp),
                    horizontalArrangement = Arrangement.End,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Button(onClick = {
                        inspectionViewModel.updatePiec(
                            obiektKontroli = obiektKontroli,
                            typPaliwa = typPaliwa
                        )
                        navController.navigate(Navigation.InspectionForm.route)
                    }) {
                        Text(text = "Dalej")
                    }
                }
            }
        }
        else if (maxWidth > 600.dp){
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
                    Text(text = "Dane kontrolowanego obiektu", fontSize = 25.sp)
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(0.05f)
                            .padding(horizontal = 25.dp)
                            .padding(top = 14.dp)
                    ) {
                        Text(text = "Obiekt kontroli")
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
                            .padding(horizontal = 25.dp)
                            .fillMaxWidth()
                    ) {
                        OutlinedTextField(
                            modifier = Modifier
                                .fillMaxWidth(),
                            value = obiektKontroli,
                            onValueChange = { obiektKontroli = it }
                        )
                    }
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(0.05f)
                            .padding(horizontal = 25.dp)
                            .padding(top = 14.dp)
                    ) {
                        Text(text = "Typ paliwa")
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
                            .padding(horizontal = 25.dp)
                            .fillMaxWidth()
                    ) {
                        OutlinedTextField(
                            modifier = Modifier
                                .fillMaxWidth(),
                            value = typPaliwa,
                            onValueChange = { typPaliwa = it }
                        )
                    }
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 18.dp)
                        .padding(end = 25.dp),
                    horizontalArrangement = Arrangement.End,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Button(onClick = {
                        inspectionViewModel.updatePiec(
                            obiektKontroli = obiektKontroli,
                            typPaliwa = typPaliwa
                        )
                        navController.navigate(Navigation.InspectionForm.route)
                    }) {
                        Text(text = "Dalej")
                    }
                }
            }
        }
    }
}