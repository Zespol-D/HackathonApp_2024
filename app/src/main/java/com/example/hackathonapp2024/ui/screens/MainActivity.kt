package com.example.hackathonapp2024.ui.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.hackathonapp2024.classes.Navigation
import com.example.hackathonapp2024.ui.theme.HackathonApp2024Theme
import com.example.hackathonapp2024.viewModel.InspectionViewModel
import com.example.hackathonapp2024.viewModel.RequestInspectionViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        //enableEdgeToEdge()
        setContent {
            HackathonApp2024Theme {
               Surface(
                   modifier = Modifier.fillMaxSize(),
                   color = MaterialTheme.colorScheme.background
               ) {
                   val inspectionViewModel = InspectionViewModel()
                   val requestInspectionViewModel = RequestInspectionViewModel()
                   val navController = rememberNavController()

                   NavHost(navController = navController, startDestination = Navigation.InspectionForm.route) {
                       composable(Navigation.Home.route) {
                           HomeScreen(activity = this@MainActivity, navController = navController,
                               inspectionViewModel = inspectionViewModel, requestInspectionViewModel = requestInspectionViewModel
                           )
                       }
                       composable(Navigation.Login.route) {
                           LoginScreen(activity = this@MainActivity, navController = navController)
                       }
                       composable(Navigation.AdminPanel.route) {
                           AdminPanel(navController = navController)
                       }
                       composable(Navigation.AdressScreenForm.route) {
                           AdressScreenForm(navController = navController, inspectionViewModel = inspectionViewModel)
                       }
                       composable(Navigation.ControlledPersonForm.route) {
                           ControlledPersonScreen(navController = navController, inspectionViewModel = inspectionViewModel)
                       }
                       composable(Navigation.ControlledPersonForm.route) {
                           ControlledPersonScreen( navController = navController, inspectionViewModel = inspectionViewModel)
                       }
                       composable(Navigation.FurnaceForm.route) {
                           FurnaceScreen(navController = navController, inspectionViewModel = inspectionViewModel)
                       }
                       composable(Navigation.InspectionForm.route) {
                           InspectionResultScreen(navController = navController, inspectionViewModel = inspectionViewModel)
                       }
                       composable(Navigation.RequestEditForm.route) {
                           RequestEditForm(navController = navController, inspectionRequestEditJson = requestInspectionViewModel)
                       }
                   }
               }
            }
        }
    }
}
