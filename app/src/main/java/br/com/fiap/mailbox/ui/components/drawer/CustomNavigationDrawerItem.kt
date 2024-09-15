package br.com.fiap.mailbox.ui.components.drawer

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun CustomNavigationDrawerItem(
    labelText: String,
    icon: ImageVector, // Ícone obrigatório
    badgeContent: String?, // Badge opcional
    selected: Boolean, // Define se o item está selecionado
    onClick: () -> Unit, // Ação ao clicar
    modifier: Modifier = Modifier // Modificador adicional para o layout
) {
    NavigationDrawerItem(
        label = {
            // Texto do item
            Text(
                text = labelText,
                color = if (selected) {
                    MaterialTheme.colorScheme.primaryContainer
                } else {
                    MaterialTheme.colorScheme.secondary
                } // Muda a cor do texto com base na seleção
            )
        },
        selected = selected,
        onClick = onClick,
        icon = {
            // Ícone do item
            Icon(
                imageVector = icon,
                tint = if (selected) {
                    MaterialTheme.colorScheme.primaryContainer
                } else {
                    MaterialTheme.colorScheme.tertiary
                }, // Muda a cor do ícone com base na seleção
                contentDescription = null
            )
        },
        modifier = modifier
            .fillMaxWidth()
            .height(48.dp), // Altura fixa para o item
        badge = {
            // Exibe o badge somente se ele não for nulo
            badgeContent?.let {
                Text(
                    text = it,
                    color = if (selected) {
                        MaterialTheme.colorScheme.primaryContainer
                    } else {
                        MaterialTheme.colorScheme.tertiary
                    } // Muda a cor do badge com base na seleção
                )
            }
        },
        shape = RoundedCornerShape(12.dp), // Borda arredondada para o item
        colors = NavigationDrawerItemDefaults.colors(
            selectedContainerColor = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.3f),
            unselectedContainerColor = Color.Transparent // Define as cores de seleção e não-seleção
        )
    )
}