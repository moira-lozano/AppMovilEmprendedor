package com.example.emprendedor.data.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, "emprendedor.db", null, 1) {
    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(
            """CREATE TABLE productos (
                id INTEGER PRIMARY KEY NOT NULL, 
                nombre VARCHAR, 
                descripcion VARCHAR, 
                precio REAL, 
                unidad VARCHAR, 
                cantidad INTEGER, 
                estado VARCHAR, 
                foto VARCHAR, 
                id_inventario INTEGER, 
                id_subcategoria INTEGER, 
                id_catalogo INTEGER, 
                id_notaVenta INTEGER)"""
        )
    }


    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        Log.d("DatabaseHelper", "Actualizando la base de datos")
        db.execSQL("DROP TABLE IF EXISTS productos")
        onCreate(db)
    }
}
