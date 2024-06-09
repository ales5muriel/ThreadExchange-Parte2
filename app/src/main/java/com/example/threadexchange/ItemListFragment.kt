package com.example.threadexchange

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.threadexchange.adapter.RopaAdapter
import com.example.threadexchange.databinding.FragmentItemListBinding
class ItemListFragment : Fragment() {
    private var _binding: FragmentItemListBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentItemListBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (requireActivity() as AppCompatActivity).supportActionBar?.title = getString(R.string.item_list_title)
        iniciarRecyclerView()
        binding.btnPerfil.setOnClickListener {
           // findNavController().navigate(R.id.action_itemListFragment_to_userInfoFragment2)
        }
        binding.reciclerRopa.adapter = RopaAdapter(RopaProvider.listRopa) { datos ->
            onItemSelected(datos)
        }
    }
    private fun iniciarRecyclerView() {
        val layoutManager = GridLayoutManager(requireContext(), 1)
        binding.reciclerRopa.layoutManager = layoutManager
    }
    private fun onItemSelected(datos: Ropa) {
        val bundle = Bundle().apply {
            putString("ropaNombre", datos.Nombre)
            putString("ropaMarca", datos.Marca)
            putString("ropaTamano", datos.Talla)
            putString("ropaFoto", datos.foto)
        }
       // findNavController().navigate(R.id.action_itemListFragment_to_detailItemFragment, bundle)
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}