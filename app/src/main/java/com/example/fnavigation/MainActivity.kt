package com.example.fnavigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.fnavigation.ui.theme.FNavigationTheme

sealed class Destination(val route: String) {
    object ScreenFirst : Destination("ScreenFirst")
    object ScreenSecond : Destination("ScreenSecond")
    object ScreenThird : Destination("ScreenThird")
    object ScreenFourth : Destination("ScreenFourth")
    object ScreenFive : Destination("ScreenFive")

}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FNavigationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = Destination.ScreenFirst.route) {
                        composable(Destination.ScreenFirst.route) { Screen1(navController) }
                        composable(Destination.ScreenSecond.route) { Screen2(navController) }
                        composable(Destination.ScreenThird.route) { Screen3(navController) }
                        composable(Destination.ScreenFourth.route) { Screen4(navController) }
                        composable(Destination.ScreenFive.route) { Screen5(navController) }
                    }
                }
            }
        }
    }
}

