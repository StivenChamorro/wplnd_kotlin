package com.example.mi_primera_app.screens

import androidx.compose.foundation.layout.*
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController
import com.example.mi_primera_app.R

@Composable
fun WooperlandRegisterScreen(navController: NavController) {
    Row(modifier = Modifier.fillMaxSize()) {
        // Sección de la izquierda con la imagen
        Box(
            modifier = Modifier
                .weight(1f)
                .background(Color(0xFFFFEB3B)) // Color amarillo de fondo
        ) {
            Image(
                painter = painterResource(id = R.drawable.imglogin), // Ajusta esto con tu imagen
                contentDescription = "Wooperland",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
        }

        // Sección de la derecha con el formulario de registro
        Column(
            modifier = Modifier
                .weight(1f)
                .background(Color(0xFFE91E63)) // Color rosado de fondo
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Indicador de pasos
            StepsIndicator()
            Spacer(modifier = Modifier.height(24.dp))

            // Campos de texto para el registro
            RegisterTextField(label = "First Name", iconRes = R.drawable.imgpersona)
            Spacer(modifier = Modifier.height(16.dp))
            RegisterTextField(label = "Last Name", iconRes = R.drawable.imgpersona)
            Spacer(modifier = Modifier.height(16.dp))
            RegisterTextField(label = "Age", iconRes = R.drawable.imgcalendario)
            Spacer(modifier = Modifier.height(16.dp))
            RegisterTextField(label = "Phone Number", iconRes = R.drawable.imgtelefono)
            Spacer(modifier = Modifier.height(16.dp))
            RegisterTextField(label = "Relationship", iconRes = R.drawable.imgadultonino)

            Spacer(modifier = Modifier.height(24.dp))

            // Botón de continuar
            Button(
                onClick = { navController.navigate("home") }, // Acción del botón de registro
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .clip(RoundedCornerShape(12.dp)),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFFFC107)) // Color del botón "Continuar"
            ) {
                Text(text = "CONTINUAR", fontWeight = FontWeight.Bold, color = Color.Black)
            }
        }
    }
}

@Composable
fun RegisterTextField(label: String, iconRes: Int) {
    OutlinedTextField(
        value = "",
        onValueChange = { /* Cambiar el valor */ },
        label = { Text(text = label) },
        leadingIcon = {
            Icon(
                painter = painterResource(id = iconRes),
                contentDescription = null,
                modifier = Modifier.size(24.dp)
            )
        },
        modifier = Modifier.fillMaxWidth()
    )
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
        StepCircle(stepNumber = 1, isActive = true)
        Spacer(modifier = Modifier.width(8.dp))
        StepCircle(stepNumber = 2, isActive = false)
        Spacer(modifier = Modifier.width(8.dp))
        StepCircle(stepNumber = 3, isActive = false)
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

