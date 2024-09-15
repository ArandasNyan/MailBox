package br.com.fiap.mailbox.ui.components.drawer

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun CustomLabelNavigationItem(
    labelText: String,
    colorCode: Int?,  // Cor opcional para a caixa
    badgeContent: String?,  // Conteúdo opcional do badge
    selected: Boolean,  // Indica se está selecionado ou não
    onClick: () -> Unit,  // Ação quando clicado
    modifier: Modifier = Modifier  // Modificador adicional para o layout
) {
    NavigationDrawerItem(
        label = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    // Caixa de cor ao lado do label
                    val resultColor = colorCode?.let { getColorByCode(it) } ?: Color.Transparent

                    Box(
                        modifier = Modifier
                            .width(20.dp)
                            .height(20.dp)
                            .background(color = Color.Transparent, shape = RoundedCornerShape(4.dp))
                            .border(width = 2.dp, color = resultColor, shape = RoundedCornerShape(4.dp))
                    )

                    Spacer(modifier = Modifier.width(8.dp))

                    // Texto da label
                    Text(
                        text = labelText,
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }
        },
        selected = selected,
        onClick = onClick,
        modifier = modifier
            .fillMaxWidth()
            .height(48.dp),
        badge = {
            // Exibe o badge somente se ele não for nulo
            badgeContent?.let {
                Text(text = it)
            }
        },
        shape = RoundedCornerShape(12.dp),  // Forma arredondada dos itens
        colors = NavigationDrawerItemDefaults.colors(
            selectedContainerColor = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.3f),
            unselectedContainerColor = Color.Transparent
        )
    )
}

fun getColorByCode(code: Int): Color {
    return when (code) {
        1 -> Color.Blue
        2 -> Color.Red
        3 -> Color.Black
        4 -> Color(0xFF00FF00)
        5 -> Color(0xFFC0C0C0)
        6 -> Color(0xFF800080)
        7 -> Color(0xFFFF00FF)
        else -> Color.DarkGray
    }
}
