package com.example.proyectofinal

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.proyectofinal.databinding.FragmentCarritoBinding
import com.example.proyectofinal.databinding.FragmentProductBinding


class CarritoFragment : Fragment() {
    private lateinit var binding: FragmentCarritoBinding
    private val mainViewModel : MainViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCarritoBinding.inflate(layoutInflater)


        mainViewModel.getProducts()
        //si es fragment
        //es con viewLifecycleOwner en lugar de this

        mainViewModel.savedProducts.observe(viewLifecycleOwner) { productsList ->
            if (productsList.isNotEmpty()) {
                Log.i("Estos son los usuarios", "${productsList.toString()} or empty")
                binding.rvProductCarritoEntries.adapter = AdapterCarrito(productsList)
            } else {
                Log.e("Estos son los usuarios", "null or empty")
            }
        }

        return binding.root
    }

}