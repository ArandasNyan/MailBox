package br.com.fiap.mailbox.ui.components.email

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.com.fiap.mailbox.model.email.Email

@Composable
fun EmailList(
    emails: List<Email>, // Receba a lista de emails aqui
    modifier: Modifier = Modifier,
    navController: NavController,
    onArchive: (Email) -> Unit,
    onDelete: (Email) -> Unit,
    onFavorite: (Email) -> Unit
) {

    LazyColumn(modifier = modifier.fillMaxSize().padding(4.dp, 0.dp)) {
        items(emails) { email ->
            EmailItem(
                email = email,
                navController = navController,
                onArchive = { onArchive(email) },
                onDelete = { onDelete(email) },
                onFavorite = { onFavorite(email) }
            )
            Spacer(modifier = Modifier.height(4.dp))
        }
    }
}
