package br.com.fiap.mailbox.ui.components.drawer

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
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
    labelColor: Color?,  // Agora usa diretamente o tipo `Color` para a caixa
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
                    Box(
                        modifier = Modifier
                            .width(20.dp)
                            .height(20.dp)
                            .background(color = Color.Transparent, shape = RoundedCornerShape(4.dp))
                            .border(width = 2.dp, color = labelColor ?: Color.DarkGray, shape = RoundedCornerShape(4.dp))
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
