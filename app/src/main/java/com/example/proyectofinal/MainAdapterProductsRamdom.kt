package com.example.proyectofinal
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectofinal.databinding.ItemProductRamdomBinding
import com.example.proyectofinal.remote.ProductoEntry
import com.squareup.picasso.Picasso

class MainAdapterProductsRamdom (private val productos: List<ProductoEntry>): RecyclerView.Adapter<MainAdapterProductsRamdom.MainHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainAdapterProductsRamdom.MainHolder {
        val binding = ItemProductRamdomBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MainAdapterProductsRamdom.MainHolder(binding)
    }

    override fun onBindViewHolder(holder: MainAdapterProductsRamdom.MainHolder, position: Int) {
        holder.render(productos.get(position))
    }

    override fun getItemCount(): Int {
        return productos.size
    }

    class MainHolder(val binding:ItemProductRamdomBinding):RecyclerView.ViewHolder(binding.root) {
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