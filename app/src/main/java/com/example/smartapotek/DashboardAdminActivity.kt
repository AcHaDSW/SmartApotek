package com.example.smartapotek

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class DashboardAdminActivity : AppCompatActivity() {

    private lateinit var db: DatabaseReference

    private lateinit var txtTotalObat: TextView
    private lateinit var txtStok: TextView
    private lateinit var txtPesanan: TextView
    private lateinit var txtVerifikasi: TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_dashboard_admin)

        txtTotalObat = findViewById(R.id.txtTotalObat)
        txtStok = findViewById(R.id.txtStok)
        txtPesanan = findViewById(R.id.txtPesanan)
        txtVerifikasi = findViewById(R.id.txtVerifikasi)

        db = FirebaseDatabase.getInstance().reference

        loadDashboard()
    }

    private fun loadDashboard() {

        db.child("obat").get().addOnSuccessListener {

            txtTotalObat.text =
                it.childrenCount.toString()

            var totalStok = 0

            for (data in it.children) {

                totalStok +=
                    data.child("stok")
                        .getValue(Int::class.java)
                        ?: 0
            }

            txtStok.text =
                totalStok.toString()
        }

        db.child("pesanan").get()
            .addOnSuccessListener {

                txtPesanan.text =
                    it.childrenCount.toString()
            }

        db.child("verifikasi").get()
            .addOnSuccessListener {

                txtVerifikasi.text =
                    it.childrenCount.toString()
            }
    }
}