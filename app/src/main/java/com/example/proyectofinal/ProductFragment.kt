package com.example.proyectofinal

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.proyectofinal.databinding.FragmentProductBinding
import com.example.proyectofinal.remote.ProductoEntry
import com.example.proyectofinal.remote.RetrofitBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductFragment : Fragment() {

    private lateinit var binding: FragmentProductBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentProductBinding.inflate(layoutInflater)

        val database = RetrofitBuilder.create()
        val response = database.getProducts()

        // var allProducts : List<ProductoEntry>
        //allProducts = emptyList()

        response.enqueue(object : Callback<List<ProductoEntry>> {
            override fun onResponse(call: Call<List<ProductoEntry>>, response : Response<List<ProductoEntry>>){
                Log.e("retrofitResponse", "${response.body()?.get(0)}")
                var productos : List<ProductoEntry>? = response.body()
                if(productos != null) {
                    binding.rvProductEntries.adapter = MainAdapterProducts(productos)

                    var arrayProductos :Array<ProductoEntry> = productos.toTypedArray()
                    arrayProductos.shuffle()
                    var listaProductos = arrayProductos.copyOfRange(0,5).toList()

                    binding.rvProductEntriesRamdom.adapter = MainAdapterProductsRamdom(listaProductos)
                } else {
                    Log.e("retrofitResponse", "****ES NULL****")
                }
            }

            override fun onFailure(call: Call<List<ProductoEntry>>, t: Throwable){
                Log.e("retrofitResponse", "error: ${t.message}")
            }
        })

        return binding.root
    }
}