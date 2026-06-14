package com.example.smartapotek

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class DashboardPelangganActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_dashboard_pelanggan)

        val btnBelanja =
            findViewById<CardView>(R.id.btnBelanja)

        val btnRiwayat =
            findViewById<CardView>(R.id.btnRiwayat)

        btnBelanja.setOnClickListener {

            startActivity(
                Intent(
                    this,
                    PesanObatActivity::class.java
                )
            )

        }

        btnRiwayat.setOnClickListener {

            startActivity(
                Intent(
                    this,
                    RiwayatPesananActivity::class.java
                )
            )

        }

    }
}