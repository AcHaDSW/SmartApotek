package com.example.smartapotek

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.smartapotek.adapter.ObatAdapter
import com.example.smartapotek.model.Obat
import com.google.firebase.database.*

class PesanObatActivity :
    AppCompatActivity(){

    lateinit var rv:
            RecyclerView

    lateinit var list:
            ArrayList<Obat>

    lateinit var adapter:
            ObatAdapter


    override fun onCreate(
        savedInstanceState:
        Bundle?
    ){

        super.onCreate(
            savedInstanceState
        )

        setContentView(
            R.layout.activity_pesan_obat
        )

        rv=
            findViewById(
                R.id.rvObat
            )

        rv.layoutManager=
            LinearLayoutManager(
                this
            )

        list=
            ArrayList()

        adapter=
            ObatAdapter(
                list
            )

        rv.adapter=
            adapter


        FirebaseDatabase
            .getInstance()
            .getReference(
                "obat"
            )

            .addValueEventListener(

                object:
                    ValueEventListener{

                    override fun onDataChange(
                        snapshot:
                        DataSnapshot
                    ){

                        list.clear()

                        for(
                        data
                        in
                        snapshot.children
                        ){

                            val obat=
                                data.getValue(
                                    Obat::class.java
                                )

                            if(
                                obat!=null
                            ){

                                list.add(
                                    obat
                                )

                            }

                        }

                        adapter.notifyDataSetChanged()

                    }

                    override fun onCancelled(
                        error:
                        DatabaseError
                    ){

                    }

                }

            )

    }

}