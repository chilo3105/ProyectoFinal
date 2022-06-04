package com.example.proyectofinal

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.text.isDigitsOnly
import com.example.proyectofinal.databinding.FragmentBuscarBinding
import com.example.proyectofinal.databinding.FragmentProductBinding
import com.example.proyectofinal.remote.ProductoEntry
import com.example.proyectofinal.remote.RetrofitBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BuscarFragment : Fragment() {

    private lateinit var binding: FragmentBuscarBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentBuscarBinding.inflate(layoutInflater)

        //listener
        binding.btnSearch.setOnClickListener {
            val database = RetrofitBuilder.create()
            val response = database.getProducts()

            val leido : String = binding.etTxtBusca.text.toString()
            if(leido.isNotEmpty() && leido.isDigitsOnly()) {
                response.enqueue(object : Callback<List<ProductoEntry>> {
                    override fun onResponse(
                        call: Call<List<ProductoEntry>>,
                        response: Response<List<ProductoEntry>>
                    ) {
                        Log.e("retrofitResponse", "${response.body()?.get(0)}")
                        var productos: List<ProductoEntry>? = response.body()
                        if (productos != null) {
                            for (producto in productos) {
                                if(producto.id == leido.toInt()) {
                                    var result: List<ProductoEntry> = listOf(producto)
                                    binding.rvProductEntriesSearch.adapter = MainAdapterProducts(result)
                                    break
                                }
                            }
                        }else {
                            Log.e("retrofitResponse", "****ES NULL****")
                        }
                    }

                    override fun onFailure(call: Call<List<ProductoEntry>>, t: Throwable) {
                        Log.e("retrofitResponse", "error: ${t.message}")
                    }
                })
            }
        }
        return binding.root
    }
}