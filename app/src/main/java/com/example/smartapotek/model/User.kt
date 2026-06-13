package com.smartapotek.model

data class User(
    val id: Int,
    val nama: String,
    val email: String,
    val password: String,
    val role: String
)