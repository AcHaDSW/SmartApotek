package com.smartapotek.model

data class Transaksi(
    val id: Int,
    val tanggal: String,
    val totalHarga: Double,
    val status: String
)