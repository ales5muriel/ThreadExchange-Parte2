package com.example.threadexchange

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.threadexchange.databinding.FragmentMenuBinding


class MenuFragment : Fragment() {
   private var _binding: FragmentMenuBinding? = null
    private val binding
        get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentMenuBinding.inflate(inflater,container, false)
        binding.btnSalir.setOnClickListener(){
            findNavController().navigate(R.id.action_menuFragment_to_login2Fragment5)
        }
        binding.btnCreditos.setOnClickListener(){
            findNavController().navigate(R.id.action_menuFragment_to_creditFragment)
        }
        binding.btnLista.setOnClickListener {
            findNavController().navigate(R.id.action_menuFragment_to_recyclerFragment)
        }

        return binding.root
    }
}