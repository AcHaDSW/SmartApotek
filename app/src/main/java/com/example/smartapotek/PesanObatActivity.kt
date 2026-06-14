package com.example.smartapotek

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.smartapotek.adapter.ObatAdapter
import com.example.smartapotek.model.Obat
import com.google.firebase.database.*

open class PesanObatActivity : AppCompatActivity() {

    private lateinit var rv: RecyclerView
    private lateinit var list: ArrayList<Obat>
    private lateinit var adapter: ObatAdapter

    override fun onCreate(
        savedInstanceState: Bundle?
    ) {

        super.onCreate(
            savedInstanceState
        )


        when (
            this::class.java.simpleName
        ) {

            "KelolaObatActivity" -> {

                setContentView(
                    R.layout.activity_kelola_obat
                )

            }

            "KelolaStokActivity" -> {

                setContentView(
                    R.layout.activity_kelola_stok
                )

            }

            else -> {

                setContentView(
                    R.layout.activity_pesan_obat
                )

            }

        }


        rv =
            findViewById(
                R.id.rvObat
            )

        rv.layoutManager =
            LinearLayoutManager(
                this
            )

        list =
            ArrayList()

        adapter =
            ObatAdapter(
                list
            )

        rv.adapter =
            adapter


        FirebaseDatabase
            .getInstance()
            .reference
            .child(
                "obat"
            )

            .addValueEventListener(

                object :
                    ValueEventListener {

                    override fun onDataChange(
                        snapshot: DataSnapshot
                    ) {

                        list.clear()

                        Log.d(
                            "FIREBASE",
                            snapshot.childrenCount.toString()
                        )

                        for (
                        data
                        in
                        snapshot.children
                        ) {

                            val nama =
                                data.child(
                                    "nama"
                                ).getValue(
                                    String::class.java
                                ) ?: ""

                            val harga =
                                data.child(
                                    "harga"
                                ).getValue(
                                    Int::class.java
                                ) ?: 0

                            val kategori =
                                data.child(
                                    "kategori"
                                ).getValue(
                                    String::class.java
                                ) ?: ""

                            val stok =
                                data.child(
                                    "stok"
                                ).getValue(
                                    Int::class.java
                                ) ?: 0


                            list.add(

                                Obat(
                                    nama,
                                    harga,
                                    kategori,
                                    stok
                                )

                            )

                        }

                        adapter.notifyDataSetChanged()

                        Toast.makeText(
                            this@PesanObatActivity,
                            "Data: ${list.size}",
                            Toast.LENGTH_SHORT
                        ).show()

                    }

                    override fun onCancelled(
                        error: DatabaseError
                    ) {

                        Toast.makeText(
                            this@PesanObatActivity,
                            error.message,
                            Toast.LENGTH_LONG
                        ).show()

                    }

                }

            )

    }

}