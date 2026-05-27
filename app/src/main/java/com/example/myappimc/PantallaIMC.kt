package com.example.myappimc

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun PantallaIMC() {
    var peso by remember { mutableStateOf("") }
    var altura by remember { mutableStateOf("") }
    var resultadoImc by remember { mutableStateOf("") }
    var clasificacion by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Calculadora de IMC",
            fontSize = 28.sp,
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(bottom = 32.dp)
        )

        PesoField(value = peso, onValueChange = { peso = it })
        AlturaField(value = altura, onValueChange = { altura = it })

        Button(
            onClick = {
                val p = peso.toDoubleOrNull()
                val a = altura.toDoubleOrNull()

                if (p != null && a != null && a > 0) {
                    val imc = calcularIMC(p, a)
                    resultadoImc = formatoResultado(imc)
                    clasificacion = "Clasificación: ${obtenerCategoria(imc)}"
                } else {
                    resultadoImc = "Por favor, ingresa datos válidos."
                    clasificacion = ""
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
        ) {
            Text("Calcular", fontSize = 18.sp)
        }

        Spacer(modifier = Modifier.height(32.dp))

        ResultDisplay(resultado = resultadoImc, clasificacion = clasificacion)
    }
}
