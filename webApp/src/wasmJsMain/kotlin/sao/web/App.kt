package sao.web

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import domain.WaveCalculator



@Composable
fun App() {
    MaterialTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            var depthInput by remember { mutableStateOf("10.0") }

            val depth = 10.0
            var resultText by remember { mutableStateOf("P = 100.53 кПа") }

            val pressure = WaveCalculator.calculateHydrostaticPressure(depth)
            val rounded = (pressure * 100).toInt() / 100.0
            resultText = "P = $rounded кПа"

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(24.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Text(
                    text = "Гидростатическое давление",
                    style = MaterialTheme.typography.headlineMedium
                )

                OutlinedTextField(
                    value = depthInput,
                    onValueChange = { depthInput = it },
                    label = { Text("Глубина погружения, м") },
                    modifier = Modifier.width(300.dp)
                )

                Card(
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.primaryContainer
                    ),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text("Результат расчета:", style = MaterialTheme.typography.titleMedium)
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = resultText,
                            style = MaterialTheme.typography.headlineSmall
                        )
                    }
                }
            }
        }
    }
}