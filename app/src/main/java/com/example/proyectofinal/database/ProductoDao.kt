package com.example.proyectofinal.database

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy

@Dao
interface ProductoDao {
    @Query("SELECT * FROM $TABLE_PRODUCTS")
    fun getProductsFromDatabase(): List<ProductoEntity>

    @Query("SELECT * FROM $TABLE_PRODUCTS WHERE id = :pid")
    fun getProductById(pid: String): ProductoEntity

    @Delete()
    fun delete(product: ProductoEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun save(product: ProductoEntity)
}