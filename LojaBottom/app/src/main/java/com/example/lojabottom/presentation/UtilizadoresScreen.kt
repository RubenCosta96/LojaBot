package com.example.lojabottom.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun UtilizadoresScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize() // Fill the entire screen
            .background(Color(0xFFFFFFFF)) // Set your desired background color here
    ) {
        Text(
            text = "Bem-vindo aos Utilizadores!",
            modifier = Modifier.align(Alignment.Center) // Center the text
        )
    }
}