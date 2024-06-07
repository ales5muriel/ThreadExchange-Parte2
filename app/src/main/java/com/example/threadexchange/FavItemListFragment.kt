package com.example.threadexchange

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.threadexchange.adapter.RopaAdapter
import com.example.threadexchange.databinding.FragmentFavItemListBinding


class FavItemListFragment : Fragment() {
    private var _binding: FragmentFavItemListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFavItemListBinding.inflate(inflater, container, false)
        val root: View = binding.root
        // Obtener la lista de elementos favoritos y mostrarla en tu fragmento
        val favoritos = FavoritosManager.obtenerFavoritos()
        val adapter = RopaAdapter(favoritos) { ropa ->
            // Manejar la selección de elementos favoritos si es necesario
            // Puedes implementar esto de manera similar al RecyclerFragment si lo deseas
        }
        binding.reciclerRopa.layoutManager = LinearLayoutManager(requireContext())
        binding.reciclerRopa.adapter = adapter
        binding.btnMenu.setOnClickListener {
            findNavController().navigate(R.id.action_favItemListFragment2_to_recyclerFragment)
        }
        return root
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}