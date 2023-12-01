package com.example.planifica_vacaciones

import com.example.planifica_vacaciones.Place
import com.example.planifica_vacaciones.PlaceDao

class VacationPlannerRepository(private val placeDao: PlaceDao) {

    // Function to insert a place into the database
    suspend fun insertPlace(place: Place) {
        placeDao.insert(place)
    }

    // Function to get all places from the database
    suspend fun getAllPlaces(): List<Place> {
        return placeDao.getAllPlaces()
    }

    // Function to get a place by its ID from the database
    suspend fun getPlaceById(id: Long): Place? {
        return placeDao.getPlaceById(id)
    }
}

//Esta clase actúa como una capa de abstracción entre los orígenes de datos (en este caso, Room) y la ViewModel