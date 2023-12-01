package com.example.planifica_vacaciones

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//Este archivo proporciona una instancia única de Retrofit que puede ser utilizada en toda la aplicación
//para realizar solicitudes a servicios web a través de Retrofit.
object RetrofitClient {
    private const val BASE_URL = "https://example.com/"  // Reemplaza con la URL base correcta

    val instance: Retrofit
        get() {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
}