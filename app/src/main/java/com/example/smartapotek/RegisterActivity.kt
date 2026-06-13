package com.example.smartapotek

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_register)

        val etNama =
            findViewById<EditText>(R.id.etNama)

        val etEmail =
            findViewById<EditText>(R.id.etEmail)

        val etPassword =
            findViewById<EditText>(R.id.etPassword)

        val etConfirm =
            findViewById<EditText>(R.id.etConfirm)

        val btnRegister =
            findViewById<Button>(R.id.btnRegister)

        val tvLogin =
            findViewById<TextView>(R.id.tvLogin)

        val prefs: SharedPreferences =
            getSharedPreferences(
                "USER_DATA",
                MODE_PRIVATE
            )

        btnRegister.setOnClickListener {

            val nama =
                etNama.text.toString().trim()

            val email =
                etEmail.text.toString().trim()

            val password =
                etPassword.text.toString().trim()

            val confirm =
                etConfirm.text.toString().trim()

            if (
                nama.isEmpty()
                ||
                email.isEmpty()
                ||
                password.isEmpty()
                ||
                confirm.isEmpty()
            ) {

                Toast.makeText(
                    this,
                    "Lengkapi data",
                    Toast.LENGTH_SHORT
                ).show()

                return@setOnClickListener

            }

            if (
                password != confirm
            ) {

                Toast.makeText(
                    this,
                    "Password tidak sama",
                    Toast.LENGTH_SHORT
                ).show()

                return@setOnClickListener

            }

            prefs.edit()
                .putString(
                    "nama",
                    nama
                )
                .putString(
                    "email",
                    email
                )
                .putString(
                    "password",
                    password
                )
                .commit()

            Toast.makeText(
                this,
                "Registrasi berhasil",
                Toast.LENGTH_SHORT
            ).show()

            startActivity(
                Intent(
                    this,
                    LoginActivity::class.java
                )
            )

            finish()

        }

        tvLogin.setOnClickListener {

            finish()

        }

    }


}
