package br.com.fiap.mailbox.ui.components.drawer

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import br.com.fiap.mailbox.ui.components.global.CustomSpacer

@Composable
fun LabelsSection(
    labels: List<Pair<String, Color>>,
    onLabelSelected: (String) -> Unit,
    onLabelAdd: (String, Color) -> Unit,
    onLabelRemove: (String) -> Unit
) {
    var showDialog by remember { mutableStateOf(false) } // Estado para controlar o diálogo

    Column(modifier = Modifier.padding(12.dp, 0.dp)) {
        // Seção de cabeçalho de labels com o botão para adicionar
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp, 0.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Labels",
                modifier = Modifier.weight(1f),
                color = Color.DarkGray
            )
            IconButton(onClick = { showDialog = true }) {
                Icon(
                    imageVector = Icons.Filled.Add,
                    contentDescription = "Add Label",
                    tint = Color.DarkGray
                )
            }
        }

        // Renderiza os labels se houver algum na lista
        if (labels.isNotEmpty()) {
            labels.forEach { (labelText, color) ->
                CustomLabelNavigationItem(
                    labelText = labelText,
                    labelColor = color, // Agora passa a cor diretamente
                    badgeContent = "2",
                    selected = false, // Faça isso dinâmico se necessário
                    onClick = { onLabelSelected(labelText) }
                )
                CustomSpacer(direction = "horizontal", isFull = true)
            }
        }
    }

    // Mostra o diálogo para adicionar uma nova label
    if (showDialog) {
        AddLabelDialog(
            onDismiss = { showDialog = false },
            onLabelAdd = { name, color ->
                onLabelAdd(name, color)
                showDialog = false
            }
        )
    }
}

@Composable
fun AddLabelDialog(
    onDismiss: () -> Unit,
    onLabelAdd: (String, Color) -> Unit
) {
    var labelName by remember { mutableStateOf("") }
    var selectedColor by remember { mutableStateOf(Color.Blue) }

    AlertDialog(
        onDismissRequest = onDismiss,
        modifier = Modifier
            .fillMaxWidth(),
        title = { Text(text = "Add a label") },
        text = {
            Column {
                OutlinedTextField(
                    value = labelName,
                    onValueChange = { labelName = it },
                    label = { Text("Nome da Label") }
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text("Escolha uma cor:")
                Spacer(modifier = Modifier.height(6.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    ColorPicker(
                        currentColor = selectedColor,
                        onColorSelected = { selectedColor = it }
                    )
                }
            }
        },
        confirmButton = {
            Button(
                onClick = {
                    if (labelName.isNotBlank()) {
                        onLabelAdd(labelName, selectedColor)
                    }
                }
            ) {
                Text("Adicionar")
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text("Cancelar")
            }
        }
    )
}

@Composable
fun ColorPicker(
    currentColor: Color,
    onColorSelected: (Color) -> Unit
) {
    val colors = listOf(Color.Red, Color.Green, Color.Blue, Color.Yellow, Color.Magenta)

    Row {
        colors.forEach { color ->
            Box(
                modifier = Modifier
                    .size(32.dp)
                    .padding(2.dp)
                    .clip(CircleShape)
                    .background(color)
                    .clickable { onColorSelected(color) }
                    .border(
                        width = if (currentColor == color) 2.dp else 1.dp,
                        color = if (currentColor == color) Color.Black else Color.Transparent,
                        shape = CircleShape
                    )
            )
        }
    }
}