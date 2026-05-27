package com.example.myappimc

fun obtenerCategoria(imc: Double): String {
    return when {
        imc < 18.5 -> "Bajo peso"
        imc in 18.5..24.9 -> "Peso normal"
        imc in 25.0..29.9 -> "Sobrepeso"
        imc in 30.0..34.9 -> "Obesidad Grado I"
        imc in 35.0..39.9 -> "Obesidad Grado II"
        else -> "Obesidad Grado III"
    }
}
