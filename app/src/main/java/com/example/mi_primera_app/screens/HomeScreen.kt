package com.example.mi_primera_app.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Button
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.ButtonDefaults
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.mi_primera_app.R

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
