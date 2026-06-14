package com.example.smartapotek

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class DashboardAdminActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(
            R.layout.activity_dashboard_admin
        )

        val dataObat =
            findViewById<Button>(
                R.id.menuDataObat
            )

        val stok =
            findViewById<Button>(
                R.id.menuStok
            )

        val verifikasi =
            findViewById<Button>(
                R.id.menuVerifikasi
            )

        val laporan =
            findViewById<Button>(
                R.id.menuLaporan
            )


        // KELOLA DATA OBAT

        dataObat.setOnClickListener {

            startActivity(

                Intent(
                    this,
                    PesanObatActivity::class.java
                )

            )

        }


        // KELOLA STOK

        stok.setOnClickListener {

            startActivity(

                Intent(
                    this,
                    DetailObatActivity::class.java
                )

            )

        }


        // VERIFIKASI

        verifikasi.setOnClickListener {

            startActivity(

                Intent(
                    this,
                    RiwayatPesananActivity::class.java
                )

            )

        }


        // LAPORAN

        laporan.setOnClickListener {

            startActivity(

                Intent(
                    this,
                    StatusPesananActivity::class.java
                )

            )

        }

    }

}