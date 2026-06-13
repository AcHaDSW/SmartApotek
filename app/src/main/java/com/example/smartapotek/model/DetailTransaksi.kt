package com.smartapotek.model

data class DetailTransaksi(
    val id: Int,
    val transaksiId: Int,
    val obatId: Int,
    val jumlah: Int,
    val harga: Double
)