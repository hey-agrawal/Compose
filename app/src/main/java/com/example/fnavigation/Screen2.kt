package com.example.fnavigation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController


@Composable
fun Screen2(navController:NavHostController) {
    Scaffold(
        topBar = {
            TopAppBar { Text(text = "Screen 2") }
        }

    ) {
        // Screen content
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,

            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()

        ) {


            Text(text = "Screen 2")
            Button(onClick = {navController.navigate(Destination.ScreenThird.route)}) {
                Text(text = "Next")
            }
            Button(onClick = {navController.navigateUp()}) {
                Text(text = "Back")
            }
        }
    }
}