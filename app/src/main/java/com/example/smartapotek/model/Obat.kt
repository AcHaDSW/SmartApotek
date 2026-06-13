package com.smartapotek.model

data class Obat(
    val id: Int,
    val namaObat: String,
    val kategori: String,
    val harga: Double,
    val stok: Int,
    val deskripsi: String
)