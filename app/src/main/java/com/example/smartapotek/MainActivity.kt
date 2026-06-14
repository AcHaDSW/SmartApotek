package com.example.smartapotek

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    lateinit var auth:
            FirebaseAuth

    override fun onCreate(
        savedInstanceState:
        Bundle?
    ) {

        super.onCreate(
            savedInstanceState
        )

        auth =
            FirebaseAuth.getInstance()

        val user =
            auth.currentUser

        if (
            user != null
        ) {

            startActivity(

                Intent(
                    this,
                    DashboardPelangganActivity::class.java
                )

            )

        }

        else {

            startActivity(

                Intent(
                    this,
                    LoginActivity::class.java
                )

            )

        }

        finish()

    }

}