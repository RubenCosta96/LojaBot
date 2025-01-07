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
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

@Preview
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MembrosScreen() {
    // Estado para armazenar a lista de membros
    val membros = remember { mutableStateOf(listOf<Membro>()) }

    // Obter dados do Firebase
    LaunchedEffect(Unit) {
        val db = Firebase.firestore
        db.collection("membros")
            .get()
            .addOnSuccessListener { result ->
                val listaMembros = result.map { document ->
                    Membro(
                        nome = document.getString("nome") ?: "",
                        contacto = document.getString("contacto") ?: ""
                    )
                }
                membros.value = listaMembros
            }
            .addOnFailureListener { exception ->
                Log.w("FirebaseError", "Erro a obter membros: ", exception)
            }
    }

    // Layout principal da Screen
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(Color(0xFFFFFFFF))
    ) {
        // Título e botão de adicionar membro
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Membros",
                fontSize = 22.sp
            )

            SmallFloatingActionButton(
                onClick = { /* Implementa lógica para adicionar membro */ },
                modifier = Modifier.shadow(
                    elevation = 15.dp,
                    shape = FloatingActionButtonDefaults.smallShape
                ),
                containerColor = Color(0xFFF4F0EF),
                contentColor = Color(0xFF49454F),
            ) {
                Icon(Icons.Filled.Add, "Criar Membro")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Campo de pesquisa (opcional)
        var searchText by remember { mutableStateOf("") }
        OutlinedTextField(
            value = searchText,
            onValueChange = { searchText = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            label = { Text("Pesquisa") },
            placeholder = { Text("Procurar membro...") },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Ícone de pesquisa"
                )
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color(0xFF6200EE),
                unfocusedBorderColor = Color(0xFFBBBBBB),
                containerColor = Color(0xFFF5F5F5)
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Lista de membros (Cards dinâmicos)
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(membros.value) { membro ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .padding(horizontal = 8.dp),
                    shape = MaterialTheme.shapes.medium,
                ) {
                    Column(
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxWidth()
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Column {
                                Text(
                                    text = membro.nome,
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.Black
                                )
                                Spacer(modifier = Modifier.height(4.dp))
                                Text(
                                    text = membro.contacto,
                                    fontSize = 14.sp,
                                    color = Color.Gray
                                )
                            }
                            Button(
                                onClick = { /* Implementa lógica de Check-out */ },
                                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary)
                            ) {
                                Text(
                                    text = "Check-out",
                                    fontSize = 14.sp,
                                    color = Color.White
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

// Modelo do Membro
data class Membro(
    val nome: String,
    val contacto: String
)
