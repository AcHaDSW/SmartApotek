package com.example.smartapotek

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        // Inisialisasi Firebase Auth
        auth = FirebaseAuth.getInstance()

        // Cek user sudah login atau belum
        val user = auth.currentUser

        if (user != null) {
            // User sudah login
        } else {
            // User belum login
        }
    }
}