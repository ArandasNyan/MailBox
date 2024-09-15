package br.com.fiap.mailbox.ui.components.global

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun CustomSpacer(
    direction: String = "horizontal",  // Define a direção
    isFull: Boolean = true,            // Define se ele deve ocupar a altura/largura completa
    size: Int? = null                  // Tamanho opcional, obrigatório quando isFull = false
) {
    when (direction) {
        "horizontal" -> {
            if (isFull) {
                Spacer(modifier = Modifier.fillMaxWidth().height(4.dp)) // Preenche largura total
            } else {
                val width = size?.dp ?: throw IllegalArgumentException("Size is required when isFull is false")
                Spacer(modifier = Modifier.width(width).height(4.dp))  // Preenche largura especificada
            }
        }
        "vertical" -> {
            if (isFull) {
                Spacer(modifier = Modifier.fillMaxHeight().width(4.dp)) // Preenche altura total
            } else {
                val height = size?.dp ?: throw IllegalArgumentException("Size is required when isFull is false")
                Spacer(modifier = Modifier.height(height).width(4.dp))  // Preenche altura especificada
            }
        }
        else -> {
            Spacer(modifier = Modifier.fillMaxWidth().height(4.dp)) // Espaço padrão
        }
    }
}