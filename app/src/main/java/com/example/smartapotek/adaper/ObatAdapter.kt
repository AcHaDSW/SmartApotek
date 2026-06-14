package com.example.smartapotek.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.smartapotek.R
import com.example.smartapotek.model.Obat

class ObatAdapter(
    private val list:ArrayList<Obat>
)
    : RecyclerView.Adapter<ObatAdapter.ViewHolder>() {

    class ViewHolder(itemView: View)
        : RecyclerView.ViewHolder(itemView){

        var nama=
            itemView.findViewById<TextView>(R.id.tvNama)

        var harga=
            itemView.findViewById<TextView>(R.id.tvHarga)

        var kategori=
            itemView.findViewById<TextView>(R.id.tvKategori)

        var stok=
            itemView.findViewById<TextView>(R.id.tvStok)

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {

        val view=
            LayoutInflater
                .from(parent.context)
                .inflate(
                    R.layout.item_obat,
                    parent,
                    false
                )

        return ViewHolder(view)

    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ){

        val obat=list[position]

        holder.nama.text=
            obat.nama

        holder.harga.text=
            "Rp ${obat.harga}"

        holder.kategori.text=
            obat.kategori

        holder.stok.text=
            "Stok : ${obat.stok}"

    }

    override fun getItemCount()=
        list.size

}