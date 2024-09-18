package com.example.emprendedor.domain.models

data class Producto(
    val nombre: String,
    val descripcion: String,
    val precio: Double,
    val unidad: String,
    val cantidad: Int,
    val estado: String,
    val foto: String,

    // CLAVES FORÁNEAS
    val id_inventario: Int,
    val id_subcategoria: Int,
    val id_catalogo: Int,
    val id_nota: Int

)
