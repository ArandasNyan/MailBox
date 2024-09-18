package br.com.fiap.mailbox.ui.components.drawer

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
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
import androidx.navigation.NavController
import br.com.fiap.mailbox.R
import br.com.fiap.mailbox.ui.components.bottomSheet.BottomSheet
import br.com.fiap.mailbox.ui.components.global.CustomDivider
import br.com.fiap.mailbox.ui.components.scaffold.ScaffoldContent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DrawerModal(navController: NavController) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    var showBottomSheet by remember { mutableStateOf(false) }
    val sheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = false,
        confirmValueChange = { true } // Aceita qualquer mudança de estado
    )

    // Inicializa `labels` como uma lista vazia
    var labels by remember { mutableStateOf(emptyList<Pair<String, Color>>()) }

    ModalNavigationDrawer(
        drawerState = drawerState, // Controla o estado do drawer
        drawerContent = {
            ModalDrawerSheet(
                modifier = Modifier
                    .padding(end = 56.dp)
                    .fillMaxHeight(), // Certifique-se de que o drawer preenche a altura
                drawerContainerColor = MaterialTheme.colorScheme.background
            ) {
                Column(
                    modifier = Modifier
                        .padding(bottom = 16.dp)
                        .fillMaxSize() // Certifique-se de que a coluna principal preenche a altura total
                ) {
                    LazyColumn(
                        modifier = Modifier
                            .weight(1f) // Permite que o LazyColumn preencha o espaço disponível, mas não mais do que isso
                    ) {
                        // Adicionando os elementos fixos dentro do LazyColumn usando `item`
                        item {
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
                                        .background(
                                            color = MaterialTheme.colorScheme.primaryContainer,
                                            shape = RoundedCornerShape(8.dp)
                                        ),
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
                        }

                        item {
                            // Fixed navigation items (Inbox, Starred, etc.)
                            Column {
                                FixedNavigationItems { route ->
                                    navController.navigate(route)
                                }
                                CustomDivider(direction = "horizontal", isFull = true)
                            }
                        }

                        // Seção de labels dinâmicos
                        item {
                            LabelsSection(
                                labels = labels,
                                onLabelSelected = { label -> /* Handle label selection */ },
                                onLabelAdd = { name, color ->
                                    labels = labels + (name to color)
                                },
                                onLabelRemove = { labelToRemove ->
                                    labels = labels.filterNot { it.first == labelToRemove }
                                }
                            )
                        }
                    }

                    // Botão na parte inferior
                    Button(
                        onClick = {
                            showBottomSheet = true
                        },
                        shape = RoundedCornerShape(12.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(12.dp, 0.dp),
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
        ScaffoldContent(
            drawerState = drawerState,
            navController = navController
        )

        // Adicionar o modal do BottomSheet
        BottomSheet(
            showBottomSheet = showBottomSheet,
            onDismissRequest = { showBottomSheet = false },
            sheetState = sheetState,
            navController = navController // Passa o NavController
        )
    }
}
