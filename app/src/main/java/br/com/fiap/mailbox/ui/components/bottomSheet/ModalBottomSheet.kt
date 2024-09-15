package br.com.fiap.mailbox.ui.components.bottomSheet

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import br.com.fiap.mailbox.R
import br.com.fiap.mailbox.ui.components.global.CustomSpacer

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheet(
    showBottomSheet: Boolean,
    onDismissRequest: () -> Unit, // Função para controlar o fechamento
    sheetState: SheetState
) {
    if (showBottomSheet) {
        ModalBottomSheet(
            onDismissRequest = onDismissRequest, // Controla o fechamento do bottom sheet
            sheetState = sheetState
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(6.dp, 0.dp, 6.dp, 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    "Configurações",
                    style = MaterialTheme.typography.headlineSmall,
                    color = MaterialTheme.colorScheme.primary
                )

                Text(
                    "Selecione qual será o setor de configuração que deseja utilizar, clicando abaixo.",
                    style = MaterialTheme.typography.bodyMedium,
                    textAlign = TextAlign.Center
                )

                CustomSpacer(direction = "vertical", isFull = false, size = 12)

                ConfigButton(
                    icon = ImageVector.vectorResource(R.drawable.user_round_cog),
                    text = "Configurações de usuário",
                    onClick = onDismissRequest // Exemplo: pode fechar ou fazer outra ação
                )

                CustomSpacer(direction = "vertical", isFull = false, size = 8)

                ConfigButton(
                    icon = ImageVector.vectorResource(R.drawable.settings),
                    text = "Configurações de aplicativo",
                    onClick = onDismissRequest
                )
            }
        }
    }
}

@Composable
fun ConfigButton(
    icon: ImageVector,
    text: String,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier
            .padding(12.dp, 0.dp)
            .height(52.dp),
        colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.tertiaryContainer)
    ) {
        Row(
            modifier = Modifier
                .weight(1f),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                icon,
                contentDescription = "Icon settings",
                tint = MaterialTheme.colorScheme.secondary
            )

            Column(
                modifier = Modifier
                    .padding(start = 8.dp)
                    .weight(1f)
            ) {
                Text(
                    text = text,
                    style = MaterialTheme.typography.bodyLarge.copy(
                        fontWeight = FontWeight.W400
                    )
                )
            }

            Icon(
                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                contentDescription = "Arrow Right",
                tint = Color.Gray
            )
        }
    }
}
