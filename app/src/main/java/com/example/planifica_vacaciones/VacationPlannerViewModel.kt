package com.example.planifica_vacaciones

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
//import com.example.planifica_vacaciones.db.Place
//import com.example.planifica_vacaciones.repository.VacationPlannerRepository
import com.example.planifica_vacaciones.Place
import com.example.planifica_vacaciones.VacationPlannerRepository
import kotlinx.coroutines.launch

class VacationPlannerViewModel(private val repository: VacationPlannerRepository) : ViewModel() {

    // Function to insert a place into the database
    fun insertPlace(place: Place) {
        viewModelScope.launch {
            repository.insertPlace(place)
        }
    }

    // Function to get all places from the database
    fun getAllPlaces() {
        viewModelScope.launch {
            repository.getAllPlaces()
        }
    }

    // Function to get a place by its ID from the database
    fun getPlaceById(id: Long) {
        viewModelScope.launch {
            repository.getPlaceById(id)
        }
    }
}

//Esta clase es responsable de preparar y gestionar los datos para la interfaz de usuario.
//Interactúa con el repositorio para acceder a los datos.