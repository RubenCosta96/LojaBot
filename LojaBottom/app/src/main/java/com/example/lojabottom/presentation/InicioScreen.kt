package com.example.lojabottom.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun InicioScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(Color(0xFFFFFFFF))
    ) {
        Text(
            text = "Olá, Tania!",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(47.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween

        ) {
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(20.dp))
                    .weight(1f)
                    .background(Color(0xFFF4F0EF))
                    .padding(16.dp)
            ) {
                Column {
                    Text(
                        text = "VISITAS HOJE",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "75",
                        fontSize = 64.sp
                    )
                }
            }

            Spacer(modifier = Modifier.width(16.dp))

            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(15.dp))
                    .weight(1f)
                    .background(Color(0xFFF4F0EF))
                    .padding(16.dp)
            ) {
                Column {
                    Text(
                        text = "EM LOJA",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "3",
                        fontSize = 64.sp
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(45.dp))
        Text(
            text = "Últimas Entradas",
            fontSize = 22.sp,
            fontWeight = FontWeight.Normal
            )
        Spacer(modifier = Modifier.height(10.dp))
        Column{
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(15.dp))
                    .background(Color(0xFFF4F0EF))
                    .padding(start = 26.dp, end = 26.dp)
            ){
                Column(modifier = Modifier.padding(vertical = 8.dp)){
                Text(text = "Francisco Silva",
                    fontSize = 16.sp)
                    Spacer(modifier = Modifier.height(16.dp))
                Text(text = "João Santos",
                    fontSize = 16.sp)
                    Spacer(modifier = Modifier.height(16.dp))
                Text(text = "Leonor Ferreira",
                    fontSize = 16.sp)
                }
            }
        }
        Spacer(modifier = Modifier.height(45.dp))
        Text(
            text = "Últimas Saídas",
            fontSize = 22.sp,
            fontWeight = FontWeight.Normal
        )
        Spacer(modifier = Modifier.height(10.dp))
        Column{
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(15.dp))
                    .background(Color(0xFFF4F0EF))
                    .padding(start = 26.dp, end = 26.dp)
            ){
                Column(modifier = Modifier.padding(vertical = 8.dp)){
                    Text(text = "Francisco Silva",
                        fontSize = 16.sp)
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(text = "João Santos",
                        fontSize = 16.sp)
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(text = "Leonor Ferreira",
                        fontSize = 16.sp)
                }
            }
        }
        Spacer(modifier = Modifier.height(45.dp))
        Text(
            text = "Top Nacionalidade Hoje",
            fontSize = 22.sp,
            fontWeight = FontWeight.Normal
        )
        Spacer(modifier = Modifier.height(10.dp))
        Column{
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(15.dp))
                    .background(Color(0xFFF4F0EF))
                    .padding(start = 26.dp, end = 26.dp)
                    .padding(vertical = 8.dp)
            ){
                    Text(text = "Portuguesa",
                        fontSize = 16.sp)
            }
        }
    }
}
