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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.hackathonapp2024.classes.Navigation
import com.example.hackathonapp2024.viewModel.RequestInspectionViewModel

@Composable
fun RequestEditForm(
    navController: NavHostController,
    inspectionRequestEditJson: RequestInspectionViewModel
){
    val inspectionRequest by inspectionRequestEditJson.inspection.collectAsState()

//    var powierzchnia by remember { mutableFloatStateOf(inspectionRequest.powierzchnia)?: 0.0f }
//    var typLokalu  by remember { mutableStateOf(inspectionRequest.typLokalu ?: "") }
//    var piec by remember { mutableStateOf(inspectionRequest.piec ?: "") }
//    var rokPieca by remember { mutableIntStateOf(inspectionRequest.rokPieca) }
//    var typPaliwa by remember { mutableStateOf(inspectionRequest.typPaliwa ?: "") }
//    var iloscPaliwa by remember { mutableFloatStateOf(inspectionRequest.iloscPaliwa) }
//    var czyUzyskDot by remember { mutableIntStateOf(inspectionRequest.czyUzyskDot)}

    var powierzchnia = inspectionRequest.powierzchnia
    var typLokalu = inspectionRequest.typLokalu
    var piec = inspectionRequest.piec
    var rokPieca = inspectionRequest.rokPieca
    var typPaliwa = inspectionRequest.typPaliwa
    var iloscPaliwa = inspectionRequest.iloscPaliwa
    var czyUzyskDot = inspectionRequest.czyUzyskDot

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
                Text(text = "Powierzchnia")
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
                    value = powierzchnia.toString(),
                    onValueChange = { powierzchnia = it.toFloat() }
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
                Text(text = "Typ lokalu")
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
                typLokalu?.let {
                    OutlinedTextField(
                        value = it,
                        onValueChange = { typLokalu = it }
                    )
                }
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
                Text(text = "Piec")
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
                piec?.let {
                    OutlinedTextField(
                        value = it,
                        onValueChange = { piec = it }
                    )
                }
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
                Text(text = "Rok pieca")
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
                    value = rokPieca.toString(),
                    onValueChange = { rokPieca = it.toInt() }
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
            ) {
                typPaliwa?.let {
                    OutlinedTextField(
                        value = it,
                        onValueChange = { typPaliwa = it }
                    )
                }
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
                Text(text = "Ilość paliwa")
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
                    value = iloscPaliwa.toString(),
                    onValueChange = { iloscPaliwa = it.toFloat() }
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
                Text(text = "Czy już uzyskano dotację?")
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
                    value = czyUzyskDot.toString(),
                    onValueChange = { czyUzyskDot = it.toInt() }
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
                powierzchnia?.let {
                    typLokalu?.let { it1 ->
                        piec?.let { it2 ->
                            rokPieca?.let { it3 ->
                                typPaliwa?.let { it4 ->
                                    iloscPaliwa?.let { it5 ->
                                        czyUzyskDot?.let { it6 ->
                                            inspectionRequestEditJson.updateForEdit(
                                                powierzchnia = it,
                                                typLokalu = it1,
                                                piec = it2,
                                                rokPieca = it3,
                                                typPaliwa = it4,
                                                iloscPaliwa = it5,
                                                czyUzyskDot = it6
                                            )
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                navController.navigate(Navigation.InspectionForm.route)
                println(inspectionRequestEditJson.inspection.value.powierzchnia)
                println(inspectionRequestEditJson.inspection.value.typPaliwa)
                println(inspectionRequestEditJson.inspection.value.piec)
                println(inspectionRequestEditJson.inspection.value.iloscPaliwa)
            }) {
                Text(text = "Dalej")
            }
        }

    }

}
