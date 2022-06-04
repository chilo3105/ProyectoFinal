package com.example.proyectofinal.database

import androidx.room.Database
import androidx.room.RoomDatabase

const val DATABASE_VERSION = 1
const val TABLE_PRODUCTS = "products"
const val DATABASE_NAME = "appdata" +
        "base.sqlite"

@Database(entities = [ProductoEntity::class],
    version = DATABASE_VERSION
)

abstract class AppDatabase : RoomDatabase(){
    abstract fun productDao(): ProductoDao

}