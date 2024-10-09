package com.example.hackathonapp2024.ui.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.hackathonapp2024.classes.Navigation
import com.example.hackathonapp2024.ui.theme.HackathonApp2024Theme

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
                   val navController = rememberNavController()
                   NavHost(navController = navController, startDestination = Navigation.Home.route) {
                       composable(Navigation.Home.route) {
                           HomeScreen(navController)
                       }
                   }

               }
            }
        }
    }
}
