package com.example.lojabottom

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.lojabottom.presentation.MainScreen
import com.example.lojabottom.ui.theme.LojaBottomTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LojaBottomTheme {
                MainScreen()
            }
        }
    }
}
