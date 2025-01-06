package com.example.lojabottom.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.lojabottom.presentation.AtividadesScreen
import com.example.lojabottom.presentation.InicioScreen
import com.example.lojabottom.presentation.MembrosScreen
import com.example.lojabottom.presentation.PerfilScreen
import com.example.lojabottom.presentation.UtilizadoresScreen

@Composable
fun NavGraph(navController: NavHostController, modifier: Modifier = Modifier) {
    NavHost(
        navController = navController,
        startDestination = "inicio",
        modifier = modifier
    ) {
        composable("inicio") { InicioScreen() }
        composable("membros") { MembrosScreen() }
        composable("atividades") { AtividadesScreen() }
        composable("utilizadores") { UtilizadoresScreen() }
        composable("perfil") { PerfilScreen() }
    }
}


