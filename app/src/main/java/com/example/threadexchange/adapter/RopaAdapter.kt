package com.example.threadexchange.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.threadexchange.Ropa
import androidx.navigation.findNavController
import com.example.threadexchange.R



class RopaAdapter(private val listRopa: List<Ropa>, private val onClickListener: (Ropa) -> Unit) : RecyclerView.Adapter<RopaViewHolder>()  {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RopaViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return RopaViewHolder(layoutInflater.inflate(R.layout.item_list, parent, false))
    }

    override fun getItemCount(): Int = listRopa.size

    override fun onBindViewHolder(holder: RopaViewHolder, position: Int) {

            holder.render(listRopa[position], onClickListener)
        holder.binding.buttonDetalles.setOnClickListener {
            val itemId = listRopa[holder.adapterPosition].id

            val bundle = bundleOf("itemId" to itemId)
            it.findNavController().navigate(R.id.action_recyclerFragment_to_detailItemFragment3, bundle)

        }

    }


}