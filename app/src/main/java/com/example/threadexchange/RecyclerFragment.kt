package com.example.threadexchange

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.threadexchange.RopaProvider.Companion.listRopa
import com.example.threadexchange.adapter.RopaAdapter
import com.example.threadexchange.databinding.FragmentRecyclerBinding


class RecyclerFragment : Fragment() {
private var _binding: FragmentRecyclerBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRecyclerBinding.inflate(inflater,container,false)
        initializeRecyclerView()


        binding.btnVolver.setOnClickListener {
            findNavController().navigate(R.id.action_recyclerFragment_to_menuFragment)

        }
        binding.btnFavoritos.setOnClickListener {
            findNavController().navigate(R.id.action_recyclerFragment_to_favItemListFragment2)

        }

        binding.btnPerfil.setOnClickListener {
            findNavController().navigate(R.id.action_recyclerFragment_to_userInfoFragment2)
        }

        // Configurar el adaptador
        val adapter = RopaAdapter(listRopa) { ropa ->
            // Mostrar un Toast con el nombre del producto seleccionado
            Toast.makeText(requireContext(), "Seleccionaste: ${ropa.Nombre}", Toast.LENGTH_SHORT).show()
            agregarAFavoritos(ropa)
        }
        return binding.root

    }

     fun initializeRecyclerView() {
         val ropaList = RopaProvider.listRopa
         if (ropaList == null || ropaList.isEmpty()) {
             Toast.makeText(requireContext(), "No hay datos disponibles", Toast.LENGTH_SHORT).show()
             return
         }
         val manager = LinearLayoutManager(requireContext())
         binding.rRopa.layoutManager = manager
         binding.rRopa.adapter = RopaAdapter(ropaList) { ropa ->
             onItemSelected(ropa)
         }
         // Añadir la decoración de ítems al RecyclerView
        // binding.rRopa.addItemDecoration(decoration)
}
    fun onItemSelected(Ropa: Ropa) {
        Toast.makeText(requireContext(),
            Ropa.Nombre,
            Toast.LENGTH_SHORT
        ).show()
    }
    private fun agregarAFavoritos(Ropa: Ropa) {
        FavoritosManager.agregarAFavoritos(Ropa)
        Toast.makeText(requireContext(), "${Ropa.Nombre} agregado a favoritos", Toast.LENGTH_SHORT).show()
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}