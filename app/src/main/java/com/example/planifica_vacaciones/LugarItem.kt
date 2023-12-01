package com.example.planifica_vacaciones

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import db.Lugar

// Composable para un item de la lista en Pantalla1
@Composable
fun LugarItem(lugar: Lugar, onClick: () -> Unit) {
    // Diseño del item
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable(onClick = onClick),
        elevation = 8.dp // Aquí, 8.dp es un valor válido para la elevación
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
        ) {
            // Contenido del item (imagen, título, costo, iconos, etc.)
            // Puedes usar Image, Text, Icon, etc., según tus necesidades
        }
    }
}

