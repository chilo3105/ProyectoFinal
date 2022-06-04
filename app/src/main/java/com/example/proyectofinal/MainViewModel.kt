package com.example.proyectofinal

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.proyectofinal.database.DatabaseManager
import com.example.proyectofinal.database.MyCoroutines
import com.example.proyectofinal.database.Producto
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {

    val savedProducts = MutableLiveData<List<Producto>>()

    fun saveUser(product: Producto){
        viewModelScope.launch{
            val productDao = DatabaseManager.instance.database.productDao()
            MyCoroutines(productDao).save(product)
        }
    }

    fun deleteUser(product: Producto){
        viewModelScope.launch{
            val productDao = DatabaseManager.instance.database.productDao()
            MyCoroutines(productDao).delete(product)
        }
    }

    fun getUsers(){
        viewModelScope.launch{
            val productDao = DatabaseManager.instance.database.productDao()
            savedProducts.value = MyCoroutines(productDao).getProducts().value
        }
    }

}