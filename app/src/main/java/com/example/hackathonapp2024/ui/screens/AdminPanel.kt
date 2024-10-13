package com.example.hackathonapp2024.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.hackathonapp2024.classes.Navigation

@Composable
fun AdminPanel(
    navController: NavHostController,
    ){
    BoxWithConstraints {
        if (maxWidth < 600.dp) {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {
                Spacer(modifier = Modifier.height(18.dp))
                Text(text = "Panel Administracyjny", fontSize = 25.sp)
                Spacer(
                    modifier = Modifier
                        .height(18.dp)
                )


            }
        }
        else if (maxWidth > 600.dp) {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {
                Spacer(modifier = Modifier.height(18.dp))
                Text(text = "Panel Administracyjny", fontSize = 36.sp)
                Spacer(
                    modifier = Modifier
                        .height(18.dp)
                )
                Button(
                    modifier = Modifier
                        .width(190.dp),
                    onClick = {
                        navController.navigate(Navigation.AdressScreenForm.route)
                    }
                ) {
                    Text(text = "Przeprowadź kontrolę")
                }

            }
        }
    }

}