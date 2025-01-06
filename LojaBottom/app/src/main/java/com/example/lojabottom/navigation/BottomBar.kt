package com.example.lojabottom.navigation

import android.graphics.drawable.shapes.OvalShape
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.lojabottom.R
import java.util.Locale

@Composable
fun BottomBar(navController: NavHostController) {
    val items = listOf("inicio", "membros", "atividades", "utilizadores", "perfil")
    var selectedItem by remember { mutableStateOf("inicio") }

    BottomNavigation(
        backgroundColor = Color(0xFFFFFFFF),
        modifier = Modifier
            .fillMaxWidth()
            .navigationBarsPadding(),
        elevation = 0.dp
    ) {
        items.forEach { screen ->
            BottomNavigationItem(
                selected = selectedItem == screen,
                onClick = {
                    selectedItem = screen
                    navController.navigate(screen) {
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                icon = {
                    Icon(
                        modifier = Modifier
                            .clip(CircleShape)
                            .background(
                                if (selectedItem == screen) Color(0xFFFFD8E4) else Color.Transparent
                            )
                            .padding(horizontal = 16.dp),
                        painter = when (screen) {
                            "inicio" -> painterResource(R.drawable.ic_home)
                            "membros" -> painterResource(R.drawable.ic_members)
                            "atividades" -> painterResource(R.drawable.ic_activities)
                            "utilizadores" -> painterResource(R.drawable.ic_users)
                            else -> painterResource(R.drawable.ic_profile)
                        },
                        contentDescription = screen,
                        tint = Color(0xFF4A4459)
                    )
                },
                label = {
                    Text(
                        text = screen.replaceFirstChar {
                            if (it.isLowerCase()) it.titlecase(Locale.getDefault())
                            else it.toString()
                        },
                        style = TextStyle(
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF4A4459)
                        )
                    )
                },
                selectedContentColor = Color(0xFF4A4459),
                unselectedContentColor = Color(0xFF4A4459),
                modifier = Modifier.weight(1f)
            )
        }
    }
}

