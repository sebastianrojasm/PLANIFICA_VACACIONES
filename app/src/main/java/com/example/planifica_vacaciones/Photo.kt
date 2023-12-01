package com.example.planifica_vacaciones

import androidx.room.Entity
import androidx.room.PrimaryKey

// Entity for Photo
@Entity(tableName = "photos") // Especifica que esta clase es una entidad de base de datos con nombre de tabla "photos"
data class Photo(
    @PrimaryKey(autoGenerate = true) // Especifica que la clave primaria se genera automáticamente y es un Long
    val id: Long = 0L, // Campo para la clave primaria

    val placeId: Long, // ID del lugar al que pertenece la foto
    val photoUri: String // URI de la foto
)