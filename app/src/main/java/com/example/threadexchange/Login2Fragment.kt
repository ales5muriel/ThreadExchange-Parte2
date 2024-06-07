package com.example.threadexchange

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.threadexchange.databinding.FragmentLogin2Binding

class Login2Fragment : Fragment() {
    private var _binding: FragmentLogin2Binding?=null
    private val binding
        get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        arguments?.let {  }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLogin2Binding.inflate(inflater, container, false)
        binding.button3.setOnClickListener {
            val username = binding.editText.text.toString() // Reemplaza `usernameEditText` con el ID correcto de tu campo de texto de usuario.
            if (username.isEmpty()) {
                // Mostrar un Toast si el campo de usuario está vacío.
                Toast.makeText(requireContext(), "Tienes que rellenar el usuario para poder pasar al siguiente fragmento", Toast.LENGTH_SHORT).show()
            } else {
                // Navegar al siguiente fragmento si el campo de usuario no está vacío.
                findNavController().navigate(R.id.action_login2Fragment5_to_viewPagerFragment)
            }
        }
        return binding.root
    }
}