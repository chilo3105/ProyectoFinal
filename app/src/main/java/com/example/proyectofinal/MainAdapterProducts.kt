package com.example.proyectofinal

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectofinal.databinding.ItemProductoBinding
import com.example.proyectofinal.remote.ProductoEntry
import com.squareup.picasso.Picasso


class MainAdapterProducts(private val productos: List<ProductoEntry>): RecyclerView.Adapter<MainAdapterProducts.MainHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainAdapterProducts.MainHolder {
        val binding = ItemProductoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MainHolder(binding)
    }

    override fun onBindViewHolder(holder: MainAdapterProducts.MainHolder, position: Int) {
        holder.render(productos.get(position))
    }

    override fun getItemCount(): Int {

        return productos.size
    }

    class MainHolder(val binding:ItemProductoBinding):RecyclerView.ViewHolder(binding.root) {
        fun render(producto: ProductoEntry) {
            //TODDO assign text and image values in render function
            binding.tvTitle.setText(producto.title)
            binding.tvPrice.setText("$ ${producto.price}")
            binding.tvDescription.setText(producto.description)
            binding.ratingBar.rating = producto.rating.rate.toFloat()
            binding.ivProduct.setImageResource(R.drawable.ic_android_black_24dp)
            Picasso.get().load("${producto.image}").into(binding.ivProduct)
        }
    }


}
