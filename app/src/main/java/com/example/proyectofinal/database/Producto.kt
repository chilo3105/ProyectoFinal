package com.example.proyectofinal.database

class Producto(
    product_id: String,
    product_title: String,
    product_price: Double,
    product_description: String,
    product_image: String,
    product_rate: Double,
    product_id_user: Int
) {

    val product_id: String = product_id
    val product_title: String  = product_title
    val product_price: Double = product_price
    val product_description: String = product_description
    val product_image: String = product_image
    val product_rate: Double = product_rate
    val product_id_user: Int = product_id_user
}



fun Producto.toEntity() = ProductoEntity(
    product_id,
    product_title,
    product_price,
    product_description,
    product_image,
    product_rate,
    product_id_user
)