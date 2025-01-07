package com.example.lojabottom.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.rememberNavController
import com.example.lojabottom.navigation.BottomBar
import com.example.lojabottom.navigation.NavGraph


@Composable
fun MainScreen() {
    val navController = rememberNavController()

    Scaffold(
        containerColor = Color(0xFFFFFFFF),
        bottomBar = {
            BottomBar(navController = navController)
        }
    ) { innerPadding ->
        // Conteúdo da tela
        NavGraph(navController = navController, modifier = Modifier.padding(innerPadding))
    }
}