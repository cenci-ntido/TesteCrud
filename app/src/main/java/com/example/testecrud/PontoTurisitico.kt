package com.example.testecrud

data class PontoTuristico(
    val id: Int = 0,  // ID auto-incrementado (0 para novo registro)
    val name: String,  // Nome do ponto turístico
    val description: String,  // Descrição do local
    val latitude: Double,  // Latitude obtida por GPS
    val longitude: Double,  // Longitude obtida por GPS
    val photo: ByteArray? = null  // Foto armazenada como array de bytes (BLOB no SQLite), pode ser nula
)
