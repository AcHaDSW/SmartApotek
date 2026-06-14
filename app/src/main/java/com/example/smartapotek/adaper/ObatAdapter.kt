package com.example.smartapotek.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.smartapotek.R
import com.example.smartapotek.model.Obat

class ObatAdapter(

    private val list:
    ArrayList<Obat>

):

    RecyclerView.Adapter<
            ObatAdapter.ViewHolder>() {

    class ViewHolder(
        itemView:View
    ):
        RecyclerView.ViewHolder(
            itemView
        ){

        val tvNama=
            itemView.findViewById<TextView>(
                R.id.tvNama
            )

        val tvHarga=
            itemView.findViewById<TextView>(
                R.id.tvHarga
            )

        val tvKategori=
            itemView.findViewById<TextView>(
                R.id.tvKategori
            )

    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {

        val view=
            LayoutInflater
                .from(
                    parent.context
                )
                .inflate(
                    R.layout.item_obat,
                    parent,
                    false
                )

        return ViewHolder(view)

    }


    override fun getItemCount()=
        list.size


    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ){

        val data=
            list[position]

        holder.tvNama.text=
            data.nama

        holder.tvHarga.text=
            "Rp ${data.harga}"

        holder.tvKategori.text=
            data.kategori

    }

}