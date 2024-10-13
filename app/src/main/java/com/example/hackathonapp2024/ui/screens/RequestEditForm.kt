package com.example.hackathonapp2024.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.hackathonapp2024.classes.Navigation
import com.example.hackathonapp2024.viewModel.RequestInspectionViewModel

@Composable
fun RequestEditForm(
    navController: NavHostController,
    inspectionRequestEditJson: RequestInspectionViewModel
){
    val inspectionRequest by inspectionRequestEditJson.inspection.collectAsState()

    var powierzchnia by remember { mutableStateOf(inspectionRequest.powierzchnia ?: 0.0f) }
    var typLokalu by remember { mutableStateOf(inspectionRequest.typLokalu ?: "") }
    var piec by remember { mutableStateOf(inspectionRequest.piec ?: "") }
    var rokPieca by remember { mutableStateOf(inspectionRequest.rokPieca ?: 0) }
    var typPaliwa by remember { mutableStateOf(inspectionRequest.typPaliwa ?: "") }
    var iloscPaliwa by remember { mutableStateOf(inspectionRequest.iloscPaliwa ?: 0.0f) }
    var czyUzyskDot by remember { mutableStateOf(inspectionRequest.czyUzyskDot ?: 0) }

    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState),
    verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(
            modifier = Modifier
                .height(18.dp)
                .fillMaxWidth()
        )
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(text = "Wniosek o dofinansowanie", fontSize = 25.sp)
        }
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(15.dp)
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
                    .padding(horizontal = 15.dp)
            ) {
                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth(),
                    value = powierzchnia.toString(),
                    onValueChange = { powierzchnia = it.toFloat() },
                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number, imeAction = ImeAction.Done),
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
                .padding(horizontal = 15.dp)
        ) {
            Column(
                modifier = Modifier
                    .weight(0.1f)
                    .fillMaxWidth()
            ) {
                typLokalu?.let {
                    OutlinedTextField(
                        modifier = Modifier
                            .fillMaxWidth(),
                        value = it,
                        onValueChange = { typLokalu = it }
                    )
                }
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
                .padding(horizontal = 15.dp)
        ) {
            Column(
                modifier = Modifier
                    .weight(0.1f)
            ) {
                piec?.let {
                    OutlinedTextField(
                        modifier = Modifier
                            .fillMaxWidth(),
                        value = it,
                        onValueChange = { piec = it }
                    )
                }
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
                .padding(horizontal = 15.dp)
        ) {
            Column(
                modifier = Modifier
                    .weight(0.1f)
            ) {
                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth(),
                    value = rokPieca.toString(),
                    onValueChange = { rokPieca = it.toInt() },
                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number, imeAction = ImeAction.Done),
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
                .padding(horizontal = 15.dp)

        ) {
            Column(
                modifier = Modifier
                    .weight(0.1f)
            ) {
                typPaliwa?.let {
                    OutlinedTextField(
                        modifier = Modifier
                            .fillMaxWidth(),
                        value = it,
                        onValueChange = { typPaliwa = it },
                        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number, imeAction = ImeAction.Done),
                    )
                }
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
                .padding(horizontal = 15.dp)
        ) {
            Column(
                modifier = Modifier
                    .weight(0.1f)
            ) {
                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth(),
                    value = iloscPaliwa.toString(),
                    onValueChange = { iloscPaliwa = it.toFloat() },
                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number, imeAction = ImeAction.Done),
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
                .padding(horizontal = 15.dp)
        ) {
            Column(
                modifier = Modifier
                    .weight(0.1f)
            ) {
                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth(),
                    value = czyUzyskDot.toString(),
                    onValueChange = {
                        czyUzyskDot = it.toInt() },
                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number, imeAction = ImeAction.Done),
                )
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(
                modifier = Modifier
                    .padding(end = 15.dp)
                    .padding(top = 15.dp),
                onClick = {
                val rokPiecaInt = rokPieca.toInt() ?: 0 // Zastosuj domyślną wartość 0 w razie błędu
                val czyUzyskDotInt = czyUzyskDot.toInt() ?: 0 // Zastosuj domyślną wartość 0 w razie błędu
                inspectionRequestEditJson.updateForEdit(
                    powierzchnia = powierzchnia,
                    typLokalu = typLokalu,
                    piec = piec,
                    rokPieca = rokPiecaInt,
                    typPaliwa = typPaliwa,
                    iloscPaliwa = iloscPaliwa,
                    czyUzyskDot = czyUzyskDotInt
                )
                navController.navigate(Navigation.InspectionForm.route)
                println(inspectionRequestEditJson.inspection.value.typLokalu)
                println(inspectionRequestEditJson.inspection.value.rokPieca)
                println(inspectionRequestEditJson.inspection.value.powierzchnia)
                println(inspectionRequestEditJson.inspection.value.typPaliwa)
                println(inspectionRequestEditJson.inspection.value.piec)
                println(inspectionRequestEditJson.inspection.value.iloscPaliwa)
                println(inspectionRequestEditJson.inspection.value.czyUzyskDot)
            }) {
                Text(text = "Dalej")
            }
        }
    }
}
