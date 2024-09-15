package br.com.fiap.mailbox.ui.components.drawer

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import br.com.fiap.mailbox.ui.components.global.CustomDivider
import br.com.fiap.mailbox.ui.components.global.CustomSpacer

@Composable
fun LabelsSection(
    labels: List<String>,
    onLabelSelected: (String) -> Unit,
    onLabelAdd: () -> Unit,
    onLabelRemove: (String) -> Unit
) {
    Column(
        modifier = Modifier.padding(horizontal = 12.dp)
    ) {
        // Seção de cabeçalho de labels com o botão para adicionar
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp, 0.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Labels",
                modifier = Modifier.weight(1f),
                color = Color.DarkGray
            )
            IconButton(onClick = onLabelAdd) {
                Icon(
                    imageVector = Icons.Filled.Add,
                    contentDescription = "Add Label",
                    tint = Color.DarkGray
                )
            }
        }

        // Renderiza os labels se houver algum na lista
        if (labels.isNotEmpty()) {
            labels.forEach { label ->
                CustomLabelNavigationItem(
                    labelText = label,
                    colorCode = 1,
                    badgeContent = "2",
                    selected = false, // Make this dynamic if needed
                    onClick = { onLabelSelected(label) }
                )
                CustomSpacer(direction = "horizontal", isFull = true)
            }
        }
    }
}