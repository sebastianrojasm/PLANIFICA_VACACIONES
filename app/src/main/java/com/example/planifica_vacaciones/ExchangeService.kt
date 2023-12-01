package com.example.planifica_vacaciones

//Este código se integra con Retrofit para facilitar la comunicación con el servicio web y
// manejar la respuesta de manera estructurada

import retrofit2.Call
import retrofit2.http.GET

interface ExchangeRateService {
    // Endpoint para obtener la tasa de cambio actual entre CLP y USD
    @GET("api/dolar")
    fun getExchangeRate(): Call<ExchangeRateResponse>
}

// Clase de respuesta para el servicio web que contiene la tasa de cambio
data class ExchangeRateResponse(
    val name: String,   // Nombre de la moneda
    val unit: String,   // Unidad de la moneda
    val value: Float     // Valor de la tasa de cambio
)
