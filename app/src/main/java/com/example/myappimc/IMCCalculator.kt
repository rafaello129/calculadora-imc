package com.example.myappimc

fun calcularIMC(peso: Double, altura: Double): Double {
    return peso / (altura * altura)
}

fun formatoResultado(imc: Double): String {
    return String.format(java.util.Locale.US, "Tu IMC es: %.2f", imc)
}
