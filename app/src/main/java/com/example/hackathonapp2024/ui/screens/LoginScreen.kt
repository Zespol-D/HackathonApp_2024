package com.example.hackathonapp2024.ui.screens

import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
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
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.hackathonapp2024.classes.Navigation

@Composable
fun LoginScreen(
    navController: NavHostController,
    activity: ComponentActivity,
){
    var username by remember { mutableStateOf("")}
    var password by remember { mutableStateOf("")}
    val isPasswordValid = remember { mutableStateOf(true) }
    val loginResult = remember { mutableStateOf("") }
    //val coroutineScope = rememberCoroutineScope()
    val keyboardController = LocalSoftwareKeyboardController.current
    fun hideKeyboard(){
        keyboardController?.hide()
    }

    // Regex pattern for password validation
    //val passwordPattern = Regex("^(?=.*[A-Z])(?=.*[a-z]{2,})(?=.*\\d)(?=.*[@\$!%*?&#])[A-Za-z\\d@\$!%*?&#]{8,}$")
    Column(
        modifier = Modifier
            .fillMaxSize()

    ) {
        BoxWithConstraints {
            if (maxWidth < 600.dp) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(0.2f),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center

                    ) {
                        Text(text = "Logowanie", fontSize = 34.sp)
                    }
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(0.6f),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        OutlinedTextField(
                            value = username,
                            onValueChange = { username = it },
                            label = { Text("Login") },
                            singleLine = true,
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text, imeAction = ImeAction.Done),
                            keyboardActions = KeyboardActions(
                                onDone = {
                                    hideKeyboard()
                                }
                            ),
                            modifier = Modifier.fillMaxWidth(0.7f)
                        )
                        Spacer(modifier = Modifier.height(16.dp))

                        OutlinedTextField(
                            value = password,
                            onValueChange = { password = it },
                            label = { Text("Hasło") },
                            visualTransformation = PasswordVisualTransformation(),
                            isError = !isPasswordValid.value,
                            singleLine = true,
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text, imeAction = ImeAction.Done),
                            keyboardActions = KeyboardActions(
                                onDone = {
                                    hideKeyboard()
                                }
                            ),
                            modifier = Modifier.fillMaxWidth(0.7f)
                        )

                        if (!isPasswordValid.value) {
                            Text(
                                text = "Hasło musi zawierać dużą literę, 2 małe litery, cyfrę, znak specjalny i mieć minimum 8 znaków",
                                color = androidx.compose.ui.graphics.Color.Red,
                                modifier = Modifier.fillMaxWidth(0.8f)
                            )
                        }
                        Spacer(modifier = Modifier.height(16.dp))

                        Button(onClick = {
                            // Sprawdzanie loginu i nawigacja na odpowiedni ekran
                            when (username) {
                                "admin" -> {
                                    navController.navigate(Navigation.AdminPanel.route)
                                }
                                "user" -> {
                                    navController.navigate(Navigation.RequestEditForm.route)
                                }
                                else -> {
                                    loginResult.value = "Dane są niepoprawne"
                                }
                            }
                        }) {
                            Text(text = "Zaloguj")
                        }

                        // Wyświetlanie wyniku logowania
                        if (loginResult.value.isNotEmpty()) {
                            Text(text = loginResult.value, color = androidx.compose.ui.graphics.Color.Red)
                        }
                    }
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(0.2f),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {

                    }
                }
            } else if (maxWidth >= 600.dp && maxWidth < 840.dp) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(0.2f),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center

                    ) {
                        Text(text = "Logowanie")
                    }
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(0.6f),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        OutlinedTextField(
                            value = username,
                            onValueChange = { username = it },
                            label = { Text("Login") },
                            singleLine = true,
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text, imeAction = ImeAction.Done),
                            keyboardActions = KeyboardActions(
                                onDone = {
                                    hideKeyboard()
                                }
                            ),
                            modifier = Modifier.fillMaxWidth(0.6f)
                        )
                        Spacer(modifier = Modifier.height(16.dp))

                        OutlinedTextField(
                            value = password,
                            onValueChange = { password = it },
                            label = { Text("Hasło") },
                            visualTransformation = PasswordVisualTransformation(),
                            isError = !isPasswordValid.value,
                            singleLine = true,
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text, imeAction = ImeAction.Done),
                            keyboardActions = KeyboardActions(
                                onDone = {
                                    hideKeyboard()
                                }
                            ),
                            modifier = Modifier.fillMaxWidth(0.6f)
                        )

                        if (!isPasswordValid.value) {
                            Text(
                                text = "Hasło musi zawierać dużą literę, 2 małe litery, cyfrę, znak specjalny i mieć minimum 8 znaków",
                                color = androidx.compose.ui.graphics.Color.Red,
                                modifier = Modifier.fillMaxWidth(0.8f)
                            )
                        }
                        Spacer(modifier = Modifier.height(16.dp))

                        Button(onClick = {
                            // Sprawdzanie loginu i nawigacja na odpowiedni ekran
                            when (username) {
                                "admin" -> {
                                    navController.navigate(Navigation.AdminPanel.route)
                                }
                                "user" -> {
                                    navController.navigate(Navigation.RequestEditForm.route)
                                }
                                else -> {
                                    loginResult.value = "Dane są niepoprawne"
                                }
                            }
                        }) {
                            Text(text = "Zaloguj")
                        }

                        // Wyświetlanie wyniku logowania
                        if (loginResult.value.isNotEmpty()) {
                            Text(text = loginResult.value, color = androidx.compose.ui.graphics.Color.Red)
                        }
                    }
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(0.2f),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {

                    }
                }
            } else if (maxWidth > 840.dp) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(0.2f),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center

                    ) {
                        Text(text = "Logowanie", fontSize = 34.sp)
                    }
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(0.6f),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        OutlinedTextField(
                            value = username,
                            onValueChange = { username = it },
                            label = { Text("Login") },
                            singleLine = true,
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text, imeAction = ImeAction.Done),
                            keyboardActions = KeyboardActions(
                                onDone = {
                                    hideKeyboard()
                                }
                            ),
                            modifier = Modifier.fillMaxWidth(0.5f)
                        )
                        Spacer(modifier = Modifier.height(16.dp))

                        OutlinedTextField(
                            value = password,
                            onValueChange = { password = it },
                            label = { Text("Hasło") },
                            visualTransformation = PasswordVisualTransformation(),
                            isError = !isPasswordValid.value,
                            singleLine = true,
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text, imeAction = ImeAction.Done),
                            keyboardActions = KeyboardActions(
                                onDone = {
                                    hideKeyboard()
                                }
                            ),
                            modifier = Modifier.fillMaxWidth(0.5f)
                        )

                        if (!isPasswordValid.value) {
                            Text(
                                text = "Hasło musi zawierać dużą literę, 2 małe litery, cyfrę, znak specjalny i mieć minimum 8 znaków",
                                color = androidx.compose.ui.graphics.Color.Red,
                                modifier = Modifier.fillMaxWidth(0.8f)
                            )
                        }
                        Spacer(modifier = Modifier.height(16.dp))

                        Button(onClick = {
                            // Sprawdzanie loginu i nawigacja na odpowiedni ekran
                            when (username) {
                                "admin" -> {
                                    navController.navigate(Navigation.AdminPanel.route)
                                }
                                "user" -> {
                                    navController.navigate(Navigation.RequestEditForm.route)
                                }
                                else -> {
                                    loginResult.value = "Błędny login"
                                }
                            }
                        }) {
                            Text(text = "Zaloguj")
                        }

                        // Wyświetlanie wyniku logowania
                        if (loginResult.value.isNotEmpty()) {
                            Text(text = loginResult.value, color = androidx.compose.ui.graphics.Color.Red)
                        }
                    }
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(0.2f),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {

                    }
                }
            }
        }
    }
}
