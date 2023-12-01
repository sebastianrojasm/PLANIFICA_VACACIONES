package com.example.planifica_vacaciones

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import db.Lugar
import kotlinx.coroutines.launch

// ViewModel para manejar la lógica de la interfaz
class MainViewModel(application: Application) : AndroidViewModel(application) {

    // LiveData para la lista de lugares
    val lugaresList: LiveData<List<Place>> by lazy {
        repository.getAllLugares().asLiveData()
    }

    // Repositorio para manejar las consultas a la base de datos
    private val repository: LugarRepository

    init {
        val lugarDao = LugarDatabase.getDatabase(application).lugarDao()
        repository = LugarRepository(lugarDao)
    }

    // Función para agregar un lugar
    fun agregarLugar(lugar: Place) {
        viewModelScope.launch {
            repository.insert(lugar)
        }
    }

    // Función para obtener un lugar por ID
    fun getLugarById(id: String): LiveData<Place> {
        return repository.getLugarById(id).asLiveData()
    }
}
