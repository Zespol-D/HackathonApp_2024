package com.example.hackathonapp2024.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.hackathonapp2024.classes.Navigation

@Composable
fun AdminPanel(
    navController: NavHostController,
    ){
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Text(text = "Panel Admina")
        Spacer(
            modifier = Modifier
                .height(18.dp)
        )
        OutlinedButton(onClick = {
            navController.navigate(Navigation.AdressScreenForm.route)
        }
        ) {
            Text(text = "Kontrola hm")
        }
    }
}