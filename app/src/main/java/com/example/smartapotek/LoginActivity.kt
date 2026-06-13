package com.example.smartapotek

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var email: EditText
    private lateinit var password: EditText

    private lateinit var btnLogin: Button
    private lateinit var tvDaftar: TextView

    private lateinit var prefs: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_login)

        prefs =
            getSharedPreferences(
                "USER_DATA",
                MODE_PRIVATE
            )

        email =
            findViewById(R.id.etEmail)

        password =
            findViewById(R.id.etPassword)

        btnLogin =
            findViewById(R.id.btnLogin)

        tvDaftar =
            findViewById(R.id.tvDaftar)

        tvDaftar.setOnClickListener {

            startActivity(
                Intent(
                    this,
                    RegisterActivity::class.java
                )
            )

        }

        btnLogin.setOnClickListener {

            val userEmail =
                email.text.toString().trim()

            val userPassword =
                password.text.toString().trim()

            if (
                userEmail.isEmpty()
                ||
                userPassword.isEmpty()
            ) {

                Toast.makeText(
                    this,
                    "Lengkapi login",
                    Toast.LENGTH_SHORT
                ).show()

                return@setOnClickListener

            }

            // LOGIN ADMIN
            if (
                userEmail ==
                "admin@smartapotek.com"
                &&
                userPassword ==
                "admin123"
            ) {

                startActivity(
                    Intent(
                        this,
                        DashboardAdminActivity::class.java
                    )
                )

                finish()

            }

            // LOGIN PELANGGAN
            else {

                val savedEmail =
                    prefs.getString(
                        "email",
                        ""
                    )

                val savedPassword =
                    prefs.getString(
                        "password",
                        ""
                    )

                if (
                    userEmail ==
                    savedEmail
                    &&
                    userPassword ==
                    savedPassword
                ) {

                    startActivity(
                        Intent(
                            this,
                            DashboardPelangganActivity::class.java
                        )
                    )

                    finish()

                } else {

                    Toast.makeText(
                        this,
                        "Silakan daftar terlebih dahulu",
                        Toast.LENGTH_SHORT
                    ).show()

                }

            }

        }

    }

}