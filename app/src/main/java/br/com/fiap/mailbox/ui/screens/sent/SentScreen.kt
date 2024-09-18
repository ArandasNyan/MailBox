package br.com.fiap.mailbox.ui.screens.sent

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.compose.ui.Modifier
import br.com.fiap.mailbox.viewmodel.EmailViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SentScreen (navController: NavController, emailViewModel: EmailViewModel) {
    val emails = emailViewModel.getEmails()
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Sent Screen") }, navigationIcon = {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                }
            })
        },
        content = { padding ->
            Column(
                modifier = Modifier
                    .padding(padding)
                    .fillMaxSize()
            ) {
                Text("This is the Sent Screen", style = MaterialTheme.typography.bodyLarge)
            }
        }
    )
}
