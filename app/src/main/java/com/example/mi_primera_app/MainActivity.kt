package com.example.mi_primera_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mi_primera_app.screens.HomeScreen
import com.example.mi_primera_app.screens.WooperlandLoginScreen
import com.example.mi_primera_app.screens.WooperlandRegisterScreen
import com.example.mi_primera_app.ui.theme.Mi_Primera_APPTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Mi_Primera_APPTheme {
                AppNavigation()
            }
        }
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "login") {
        composable("login") { WooperlandLoginScreen(navController) }
        composable("home") { HomeScreen(navController) }
        composable("register") { WooperlandRegisterScreen(navController) }
    }
}

