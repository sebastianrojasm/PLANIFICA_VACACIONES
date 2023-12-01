package com.example.planifica_vacaciones

import androidx.room.Entity
import androidx.room.PrimaryKey

// Define the Place entity with @Entity annotation
@Entity(tableName = "places")
data class Place(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0, // Campo para la clave primaria
    val name: String, // Nombre del lugar
    val visitOrder: Int, // Orden de visita del lugar
    val imageUrl: String, // URL de la imagen del lugar
    val latitude: Double, // Latitud del lugar
    val longitude: Double, // Longitud del lugar
    val accommodationCost: Double, // Costo de alojamiento en el lugar
    val transportCost: Double?, // Costo de transporte al lugar (puede ser nulo)
    val comments: String?, // Comentarios adicionales sobre el lugar (puede ser nulo)

)
