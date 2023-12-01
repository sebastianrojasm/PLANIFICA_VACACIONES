package com.example.planifica_vacaciones

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch


class PlacesViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: PlacesRepository
    val allPlaces: LiveData<List<Place>>

    init {
        val lugaresDao = VacationPlannerDatabase.getDatabase(application).placeDao()
        repository = PlacesRepository(lugaresDao)
        allPlaces = repository.allPlaces
    }

    fun insert(place: Place) = viewModelScope.launch {
        repository.insert(place)
    }

    // Add other methods as needed, e.g., update, delete
}