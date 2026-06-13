package com.example.smartapotek

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class DashboardPelangganActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_dashboard_pelanggan)

        val btnObat = findViewById<CardView>(R.id.btnObat)
        val btnKeranjang = findViewById<CardView>(R.id.btnKeranjang)
        val btnPembayaran = findViewById<CardView>(R.id.btnPembayaran)
        val btnRiwayat = findViewById<CardView>(R.id.btnRiwayat)

        btnObat.setOnClickListener {

        }

        btnKeranjang.setOnClickListener {

        }

        btnPembayaran.setOnClickListener {

        }

        btnRiwayat.setOnClickListener {

        }
    }
}