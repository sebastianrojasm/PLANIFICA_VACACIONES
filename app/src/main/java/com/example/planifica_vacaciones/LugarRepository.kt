package com.example.planifica_vacaciones

import db.Lugar
import kotlinx.coroutines.flow.Flow

// Repositorio para manejar las consultas a la base de datos
class LugarRepository(private val lugarDao: PlaceDao) {

    // Función para insertar un lugar en la base de datos
    suspend fun insert(lugar: Place) {
        lugarDao.insert(lugar)
    }

    // Función para obtener todos los lugares
    fun getAllLugares(): Flow<List<Place>> {
        return lugarDao.getAllLugares()
    }

    // Función para obtener un lugar por ID
    fun getLugarById(id: String): Flow<Place> {
        return lugarDao.getLugarById(id)
    }
}
