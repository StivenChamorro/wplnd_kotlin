package com.example.mi_primera_app.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Button
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.ButtonDefaults
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Icon
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.mi_primera_app.R

@Composable
fun WooperlandLoginScreen(navController: NavController) {
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
            LoginStepsIndicator()
            Spacer(modifier = Modifier.height(24.dp))
            LoginButton("Continuar con Google", R.drawable.imggoogle) { navController.navigate("home") }
            Spacer(modifier = Modifier.height(16.dp))
            LoginButton("Continuar con Facebook", R.drawable.imgfacebook) { navController.navigate("home") }
            Spacer(modifier = Modifier.height(16.dp))
            LoginButton("Continuar con Microsoft", R.drawable.imgwindows) { navController.navigate("home") }
            Spacer(modifier = Modifier.height(16.dp))
            LoginButton("Continuar como Invitado", R.drawable.imginvitado) { navController.navigate("home") }

            Spacer(modifier = Modifier.height(24.dp))

            // Botón para registrarse
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                TextButton(onClick = { navController.navigate("register") }) {
                    Text(
                        text = "Regístrate",
                        color = Color.Yellow,
                        fontSize = 16.sp, // Puedes ajustar el tamaño de fuente si lo deseas
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
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

@Composable
fun LoginStepsIndicator() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        LoginStepCircle(stepNumber = 1, isActive = true)
        Spacer(modifier = Modifier.width(8.dp))
        LoginStepCircle(stepNumber = 2, isActive = false)
        Spacer(modifier = Modifier.width(8.dp))
        LoginStepCircle(stepNumber = 3, isActive = false)
    }
}
@Composable
fun LoginStepCircle(stepNumber: Int, isActive: Boolean) {
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
