package com.example.hackathonapp2024.network

import android.util.Log
import com.example.hackathonapp2024.UUIDManager


import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.platform.LocalContext
import com.example.hackathonapp2024.network.networking
import com.example.hackathonapp2024.viewModel.InspectionViewModel
import com.example.hackathonapp2024.viewModel.RequestInspectionViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
fun NetworkingButton(
    inspectionViewModel: InspectionViewModel,
    requestInspectionViewModel: RequestInspectionViewModel,
    json: String
) {
    val context = LocalContext.current
    val scope = rememberCoroutineScope()

    Button(onClick = {
        scope.launch(Dispatchers.IO) {
            val uuidString = UUIDManager.getUUID() // Prepare UUID
            val (rcSuccess, dbSuccess) = networking(
                inspectionViewModel,
                requestInspectionViewModel,
                uuidString,
                json,
                responseDecoded = { response ->
                    // Handle the decoded response here, e.g., update UI or log it
                    Log.d("Response", response)
                }
            )
        }
    }) {
    }

}


