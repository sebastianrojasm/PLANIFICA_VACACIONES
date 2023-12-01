package com.example.planifica_vacaciones

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch


class PhotoViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: PhotoRepository
    val allPhotos: LiveData<List<Photo>>

    init {
        val photoDao = VacationPlannerDatabase.getDatabase(application).photoDao()
        repository = PhotoRepository(photoDao)
        allPhotos = repository.allPhotos
    }

    fun insert(photo: Photo) = viewModelScope.launch {
        repository.insert(photo)
    }

    // Función para obtener todas las fotos
    fun obtenerTodasLasFotos() = photoRepository.obtenerTodasLasFotos()

    // Función para insertar una nueva foto
    fun insertarFoto(photo: Photo) = photoRepository.insertarFoto(photo)
}

