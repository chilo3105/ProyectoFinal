package com.example.proyectofinal.database

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MyCoroutines(private val productoDao: ProductoDao) {

    suspend fun save(product: Producto) = withContext(Dispatchers.IO){
        productoDao.save(product.toEntity())
    }

    suspend fun delete (product: Producto) = withContext(Dispatchers.IO){
        productoDao.delete(product.toEntity())
    }

    suspend fun getProducts(): LiveData<List<Producto>> = withContext(Dispatchers.IO){
        return@withContext MutableLiveData(productoDao.getProductsFromDatabase().map{it.toProducto()})
    }

    suspend fun getProduct(pid: String){

    }
}