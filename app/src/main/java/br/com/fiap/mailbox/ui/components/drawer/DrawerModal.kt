package br.com.fiap.mailbox.ui.components.drawer

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.mailbox.R
import br.com.fiap.mailbox.ui.components.global.CustomDivider
import br.com.fiap.mailbox.ui.components.scaffold.ScaffoldContent

@Composable
fun DrawerModal() {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    var showBottomSheet by remember { mutableStateOf(false) }

    // Inicializa `labels` como uma lista vazia
    var labels by remember { mutableStateOf(emptyList<String>()) }

    ModalNavigationDrawer(
        drawerState = drawerState, // Controla o estado do drawer
        drawerContent = {
            ModalDrawerSheet(
                modifier = Modifier.padding(end = 56.dp),
                drawerContainerColor = MaterialTheme.colorScheme.background
            ) {
                // Top section with MailBox title and avatar
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(12.dp, 8.dp)
                        .height(48.dp),
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .size(32.dp)
                            .background(color = MaterialTheme.colorScheme.primaryContainer, shape = RoundedCornerShape(8.dp)),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            "M",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = MaterialTheme.colorScheme.primary,
                            lineHeight = 28.sp
                        )
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        "MailBox",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = MaterialTheme.colorScheme.primary
                    )
                }

                // Column containing fixed items and label section
                Column(
                    verticalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxHeight()
                        .padding(0.dp, 0.dp, 0.dp, 16.dp)
                ) {
                    // Fixed navigation items (Inbox, Starred, etc.)
                    Column {
                        FixedNavigationItems() // Fixed navigation items like Inbox, Starred, etc.
                        CustomDivider(direction = "horizontal", isFull = true)

                        // Dynamic labels section: Always show the label header and add button
                        LabelsSection(
                            labels = labels,
                            onLabelSelected = { label -> /* Handle label selection */ },
                            onLabelAdd = { /* Add a new label */
                                labels = labels + "New Label" // Isso é apenas um exemplo
                            },
                            onLabelRemove = { labelToRemove ->
                                labels = labels.filterNot { it == labelToRemove } // Remove o label selecionado
                            }
                        )
                    }

                    // Bottom section for user info and avatar
                    Button(
                        onClick = {
                            showBottomSheet = true // Exibe o BottomSheet
                        },
                        shape = RoundedCornerShape(12.dp),
                        modifier = Modifier.padding(12.dp, 0.dp),
                        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
                        colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.tertiaryContainer)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.catwhatsapp),
                            contentDescription = "User avatar",
                            modifier = Modifier
                                .size(44.dp)
                                .clip(RoundedCornerShape(99.dp)),
                            contentScale = ContentScale.Crop
                        )

                        Column(
                            modifier = Modifier
                                .padding(start = 8.dp)
                                .weight(1f)
                        ) {
                            Text(
                                text = "Arandas",
                                style = MaterialTheme.typography.bodyLarge.copy(
                                    fontWeight = FontWeight.Bold
                                )
                            )
                            Text(
                                text = "arandasnyan@gmail.com",
                                style = MaterialTheme.typography.bodySmall.copy(
                                    color = Color.Gray,
                                    fontSize = 12.sp
                                )
                            )
                        }

                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                            contentDescription = "Arrow right",
                            tint = MaterialTheme.colorScheme.secondary
                        )
                    }
                }
            }
        }
    ) {
        // Passa o estado do drawer e as funções de controle para o ScaffoldContent
        ScaffoldContent(
            drawerState = drawerState,
            showBottomSheet = showBottomSheet,
            onDismissRequest = { showBottomSheet = false }
        )
    }
}