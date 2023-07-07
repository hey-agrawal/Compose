package com.example.fnavigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
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
                        composable(Destination.ScreenFirst.route) { HomeScreen(navController) }
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

@Composable

fun CardItem(title: String, icon: ImageVector, route: String, navController: NavController) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
            .clickable { navController.navigate(route) },
        elevation = 8.dp
    ) {
        Column(
            modifier = Modifier

                .padding(16.dp)
                .fillMaxSize(),
            verticalArrangement =  Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(imageVector = icon, contentDescription = "Icon", modifier = Modifier.size(48.dp))
            Text(text = title, style = MaterialTheme.typography.h6, modifier = Modifier.padding(top = 8.dp))
        }
    }
}

