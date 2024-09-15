package br.com.fiap.mailbox.ui.components.scaffold

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import br.com.fiap.mailbox.R
import br.com.fiap.mailbox.ui.components.bottomSheet.BottomSheet
import br.com.fiap.mailbox.ui.components.email.EmailList
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldContent(
    drawerState: DrawerState, // Receber o drawerState
    onDismissRequest: () -> Unit, // Função para fechar o BottomSheet
    showBottomSheet: Boolean, // Receber o estado do BottomSheet
) {
    val scope = rememberCoroutineScope()
    val sheetState = rememberModalBottomSheetState()

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.surface,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    Text(
                        text = "Email list",
                        style = MaterialTheme.typography.headlineLarge.copy(
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { scope.launch { drawerState.open() } }) {
                        Icon(
                            Icons.Default.Menu,
                            contentDescription = "Menu Icon",
                            tint = MaterialTheme.colorScheme.primary
                        )
                    }
                },
                actions = {
                    IconButton(onClick = { /* todo */ }) {
                        Icon(
                            ImageVector.vectorResource(R.drawable.search),
                            contentDescription = "Search Icon",
                            tint = MaterialTheme.colorScheme.primary
                        )
                    }
                },
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { /* Pode exibir outra ação ou manter */ }
            ) {
                Icon(
                    Icons.Filled.Create,
                    contentDescription = "Create Icon",
                    tint = MaterialTheme.colorScheme.primary
                )
            }
        }
    ) { innerPadding ->
        EmailList(
            modifier = Modifier.padding(innerPadding),
            onArchive = { email -> /* TODO: Handle archiving */ },
            onDelete = { email -> /* TODO: Handle deleting */ },
            onFavorite = { email -> /* TODO: Handle marking as favorite */ }
        )

        // Exibe o BottomSheet se showBottomSheet for true
        if (showBottomSheet) {
            BottomSheet(
                showBottomSheet = showBottomSheet,
                onDismissRequest = onDismissRequest,
                sheetState = sheetState
            )
        }
    }
}
