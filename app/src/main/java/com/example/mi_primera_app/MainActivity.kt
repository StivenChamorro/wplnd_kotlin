package com.example.mi_primera_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
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
    }
}

@Composable
fun WooperlandLoginScreen(navController: androidx.navigation.NavController) {
    Row(modifier = Modifier.fillMaxSize()) {
        // Sección de la izquierda con la imagen
        Box(
            modifier = Modifier
                .weight(1f)
                .background(Color(0xFFFFEB3B))
        ) {
            Image(
                painter = painterResource(id = R.drawable.imglogin),
                contentDescription = "Wooperland",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
        }

        // Sección de la derecha con botones y pasos
        Column(
            modifier = Modifier
                .weight(1f)
                .background(Color(0xFFE91E63))
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            StepsIndicator()
            Spacer(modifier = Modifier.height(24.dp))
            LoginButton("Continuar con Google", R.drawable.imggoogle) { navController.navigate("home") }
            Spacer(modifier = Modifier.height(16.dp))
            LoginButton("Continuar con Facebook", R.drawable.imgfacebook) { navController.navigate("home") }
            Spacer(modifier = Modifier.height(16.dp))
            LoginButton("Continuar con Microsoft", R.drawable.imgwindows) { navController.navigate("home") }
            Spacer(modifier = Modifier.height(16.dp))
            LoginButton("Continuar como Invitado", R.drawable.imginvitado) { navController.navigate("home") }
        }
    }
}

@Composable
fun HomeScreen(navController: androidx.navigation.NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFD166))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.wooperland),
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 40.dp, bottom = 40.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.avatar),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(280.dp)
                    .padding(bottom = 40.dp)
            )
            Button(
                onClick = { /* Button action here */ },
                colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFEF476F)),
                modifier = Modifier
                    .width(200.dp)
                    .padding(vertical = 8.dp)
            ) {
                Text(
                    text = "Jugar",
                    color = Color.White
                )
            }
        }
    }
}

@Composable
fun StepsIndicator() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        StepCircle(1, true)
        Spacer(modifier = Modifier.width(8.dp))
        StepCircle(2, false)
        Spacer(modifier = Modifier.width(8.dp))
        StepCircle(3, false)
    }
}

@Composable
fun StepCircle(stepNumber: Int, isActive: Boolean) {
    val color = if (isActive) Color.Yellow else Color.White
    Box(
        modifier = Modifier
            .size(24.dp)
            .clip(RoundedCornerShape(50))
            .background(color),
        contentAlignment = Alignment.Center
    ) {
        Text(text = stepNumber.toString(), fontSize = 12.sp, fontWeight = FontWeight.Bold)
    }
}

@Composable
fun LoginButton(text: String, iconRes: Int, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .clip(RoundedCornerShape(12.dp)),
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.LightGray)
    ) {
        Icon(
            painter = painterResource(id = iconRes),
            contentDescription = null,
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = text, fontWeight = FontWeight.Bold)
    }
}