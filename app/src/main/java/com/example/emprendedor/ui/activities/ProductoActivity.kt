package com.example.emprendedor.ui.activities

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import com.example.emprendedor.R
//import com.example.emprendedor.data.database.DatabaseHelper
import com.example.emprendedor.domain.models.Producto

class ProductoActivity : AppCompatActivity() {
    lateinit var nombreEditText: EditText
    lateinit var descripcionEditText: EditText
    lateinit var precioEditText: EditText
    lateinit var unidadEditText: EditText
    lateinit var cantidadEditText: EditText
    lateinit var estadoEditText: EditText
    lateinit var fotoEditText: EditText
    lateinit var spinnerInventario: Spinner
    lateinit var spinnerSubcategoria: Spinner
    lateinit var spinnerCatalogo: Spinner
    lateinit var spinnerNota: Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_producto)

        nombreEditText = findViewById(R.id.nombre_producto)
        descripcionEditText = findViewById(R.id.descripcion_producto)
        precioEditText = findViewById(R.id.precio_producto)
        unidadEditText = findViewById(R.id.unidad_producto)
        cantidadEditText = findViewById(R.id.cantidad_producto)
        estadoEditText = findViewById(R.id.estado_producto)
        fotoEditText = findViewById(R.id.foto_producto)

        spinnerInventario = findViewById(R.id.spinner_inventario)
        spinnerSubcategoria = findViewById(R.id.spinner_subcategoria)
        spinnerCatalogo = findViewById(R.id.spinner_catalogo)
        spinnerNota = findViewById(R.id.spinner_nota)

        // Preparar datos para los spinners
        val inventarioList = listOf("Selecciona Inventario", "Inventario 1", "Inventario 2")
        val subcategoriaList = listOf("Selecciona Subcategoria", "Subcategoria 1", "Subcategoria 2")
        val catalogoList = listOf("Selecciona Catalogo", "Catalogo 1", "Catalogo 2")
        val notaList = listOf("Selecciona Nota", "Nota 1", "Nota 2")

        // Configurar adaptadores para los spinners
        val inventarioAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, inventarioList)
        inventarioAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerInventario.adapter = inventarioAdapter

        val subcategoriaAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, subcategoriaList)
        subcategoriaAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerSubcategoria.adapter = subcategoriaAdapter

        val catalogoAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, catalogoList)
        catalogoAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerCatalogo.adapter = catalogoAdapter

        val notaAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, notaList)
        notaAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerNota.adapter = notaAdapter

        findViewById<Button>(R.id.btn_guardar_producto).setOnClickListener {
            val producto = Producto(
                nombre = nombreEditText.text.toString(),
                descripcion = descripcionEditText.text.toString(),
                precio = precioEditText.text.toString().toDouble(),
                unidad = unidadEditText.text.toString(),
                cantidad = cantidadEditText.text.toString().toInt(),
                estado = estadoEditText.text.toString(),
                foto = fotoEditText.text.toString(),
                id_inventario = spinnerInventario.selectedItemPosition - 1, // Ajustar si el primer ítem es una opción de "Selecciona"
                id_subcategoria = spinnerSubcategoria.selectedItemPosition - 1,
                id_catalogo = spinnerCatalogo.selectedItemPosition - 1,
                id_nota = spinnerNota.selectedItemPosition - 1
            )

            // Aquí se llama a la capa de lógica de negocio para guardar el producto
        }
    }
}
