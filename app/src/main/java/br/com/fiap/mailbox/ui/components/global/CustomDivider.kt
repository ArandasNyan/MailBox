package br.com.fiap.mailbox.ui.components.global

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun CustomDivider(
    direction: String = "horizontal",  // Define a direção
    isFull: Boolean = true,            // Define se ele deve ocupar a altura/largura completa
    size: Int? = null,                 // Tamanho opcional, obrigatório quando isFull = false
    spacerSize: Int = 4                // Espaço de respiro em volta do divisor
) {
    // Espaçamento antes do divisor
    CustomSpacer(direction = direction, isFull = isFull, size = spacerSize)

    // Divider customizado conforme a direção
    when (direction) {
        "horizontal" -> {
            if (isFull) {
                HorizontalDivider(
                    modifier = Modifier.fillMaxWidth().height(1.dp).padding(12.dp,0.dp),
                    color = if (isSystemInDarkTheme()) {
                        MaterialTheme.colorScheme.tertiaryContainer // Cor para tema escuro
                    } else {
                        MaterialTheme.colorScheme.primary // Cor para tema claro
                    }
                )
            } else {
                val width = size?.dp ?: throw IllegalArgumentException("Size is required when isFull is false")
                HorizontalDivider(modifier = Modifier.width(width).height(1.dp).padding(12.dp,0.dp))
            }
        }
        "vertical" -> {
            if (isFull) {
                VerticalDivider(modifier = Modifier.fillMaxHeight().width(1.dp).padding(0.dp,12.dp))
            } else {
                val height = size?.dp ?: throw IllegalArgumentException("Size is required when isFull is false")
                VerticalDivider(modifier = Modifier.height(height).width(1.dp).padding(0.dp,12.dp))
            }
        }
    }

    // Espaçamento depois do divisor
    CustomSpacer(direction = direction, isFull = isFull, size = spacerSize)
}