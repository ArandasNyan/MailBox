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
import androidx.navigation.NavController
import br.com.fiap.mailbox.R
import br.com.fiap.mailbox.navigation.Routes
import br.com.fiap.mailbox.ui.components.email.EmailList
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldContent(
    drawerState: DrawerState, // Receber o drawerState
    navController: NavController // Adiciona o navController como parâmetro
) {
    val scope = rememberCoroutineScope()

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
                    IconButton(onClick = {
                        navController.navigate(Routes.Search)
                    }) {
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
                onClick = {
                    navController.navigate(Routes.ComposeEmail)
                }
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
            navController = navController,
            onArchive = { email -> /* TODO: Handle archiving */ },
            onDelete = { email -> /* TODO: Handle deleting */ },
            onFavorite = { email -> /* TODO: Handle marking as favorite */ }
        )
    }
}
