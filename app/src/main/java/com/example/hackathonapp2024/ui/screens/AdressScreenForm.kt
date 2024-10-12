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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun AdressScreenForm(
    navController: NavHostController,
){
    // tymczasowe zmienne żeby się nie srał program
    var miasto by remember { mutableStateOf("") }
    var ulica by remember { mutableStateOf("") }
    var nrBudynku by remember { mutableStateOf("") }
    var nrLokalu by remember { mutableStateOf("") }
    var typLokalu by remember { mutableStateOf("") }
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
                    .padding(horizontal = 10.dp)
            ) {
                OutlinedTextField(
                    value = miasto,
                    onValueChange = { miasto = it }
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
            ) {
                OutlinedTextField(
                    value = ulica,
                    onValueChange = { ulica = it }
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
            ) {
                OutlinedTextField(
                    value = nrBudynku,
                    onValueChange = { nrBudynku = it }
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
            ) {
                OutlinedTextField(
                    value = nrLokalu,
                    onValueChange = { nrLokalu = it }
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
            ) {
                OutlinedTextField(
                    value = typLokalu,
                    onValueChange = { typLokalu = it }
                )
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.CenterVertically
        ) {
            OutlinedButton(onClick = { /*TODO*/ }) {
                Text(text = "Dalej")
            }
        }

    }

}