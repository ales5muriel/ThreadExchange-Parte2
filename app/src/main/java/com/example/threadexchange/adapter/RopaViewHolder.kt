package com.example.threadexchange.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.threadexchange.Ropa
import com.bumptech.glide.Glide
import com.example.threadexchange.R
import com.example.threadexchange.databinding.ItemListBinding


class RopaViewHolder(view: View) : RecyclerView.ViewHolder(view){

    val Nombre = view.findViewById<TextView>(R.id.tvNombre)
    val Marca = view.findViewById<TextView>(R.id.tvMarca)
    val Tamano = view.findViewById<TextView>(R.id.tvTamano)
    val foto = view.findViewById<ImageView>(R.id.ivFoto)

    val binding = ItemListBinding.bind(view)
    fun render(RopaModel: Ropa, onClickListener: (Ropa) -> Unit){
        Nombre.text = RopaModel.Nombre
        Marca.text = RopaModel.Marca
        Tamano.text = RopaModel.Talla
        Glide.with(foto.context).load(RopaModel.foto).into(foto)
        itemView.setOnClickListener {onClickListener(RopaModel) }
    }
}