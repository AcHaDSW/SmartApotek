package com.example.smartapotek

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class DetailObatActivity :
    AppCompatActivity() {

    override fun onCreate(
        savedInstanceState: Bundle?
    ) {

        super.onCreate(
            savedInstanceState
        )

        setContentView(
            R.layout.activity_detail_obat
        )

        val imgObat =
            findViewById<ImageView>(
                R.id.imgObat
            )

        val txtNama =
            findViewById<TextView>(
                R.id.txtNamaObat
            )

        val txtHarga =
            findViewById<TextView>(
                R.id.txtHarga
            )

        val txtStok =
            findViewById<TextView>(
                R.id.txtStok
            )

        val txtDeskripsi =
            findViewById<TextView>(
                R.id.txtDeskripsi
            )

        val btnKeranjang =
            findViewById<Button>(
                R.id.btnKeranjang
            )

        txtNama.text =
            "Paracetamol"

        txtHarga.text =
            "Rp12.000"

        txtStok.text =
            "Stok tersedia"

        txtDeskripsi.text =
            "Obat untuk membantu meredakan demam dan nyeri."

        btnKeranjang.setOnClickListener {

            Toast.makeText(
                this,
                "Ditambahkan ke Keranjang",
                Toast.LENGTH_SHORT
            ).show()

        }

    }

}