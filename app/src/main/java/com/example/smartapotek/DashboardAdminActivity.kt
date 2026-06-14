package com.example.smartapotek

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class DashboardAdminActivity :
    AppCompatActivity(){

    override fun onCreate(
        savedInstanceState: Bundle?
    ){

        super.onCreate(
            savedInstanceState
        )

        setContentView(
            R.layout.activity_dashboard_admin
        )


        findViewById<Button>(
            R.id.menuDataObat
        )

            .setOnClickListener{

                startActivity(

                    Intent(
                        this,
                        KelolaObatActivity::class.java
                    )

                )

            }


        findViewById<Button>(
            R.id.menuStok
        )

            .setOnClickListener{

                startActivity(

                    Intent(
                        this,
                        KelolaStokActivity::class.java
                    )

                )

            }


        findViewById<Button>(
            R.id.menuVerifikasi
        )

            .setOnClickListener{

                startActivity(

                    Intent(
                        this,
                        VerifikasiPesananActivity::class.java
                    )

                )

            }


        findViewById<Button>(
            R.id.menuLaporan
        )

            .setOnClickListener{

                startActivity(

                    Intent(
                        this,
                        LaporanPesananActivity::class.java
                    )

                )

            }

    }

}