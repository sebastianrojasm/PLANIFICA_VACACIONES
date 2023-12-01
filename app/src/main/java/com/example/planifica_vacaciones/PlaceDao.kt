package com.example.planifica_vacaciones

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

// Interfaz para acceder a la base de datos

@Dao
interface PlaceDao {
    // Anotación que especifica la estrategia de conflicto para la
    // inserción (en este caso, ignorar si ya existe un lugar con el mismo ID).
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(place: Place)

    // Get all places from the "places" table
    @Query("SELECT * FROM places")
    suspend fun getAllPlaces(): List<Place>

    // Get a place by its ID from the "places" table
    @Query("SELECT * FROM places WHERE id = :id")
    suspend fun getPlaceById(id: Long): Place?
}