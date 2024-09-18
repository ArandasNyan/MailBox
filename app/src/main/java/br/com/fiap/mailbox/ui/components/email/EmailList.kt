package br.com.fiap.mailbox.ui.components.email

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.com.fiap.mailbox.R
import br.com.fiap.mailbox.model.email.Email

@Composable
fun EmailList(
    modifier: Modifier = Modifier,
    navController: NavController,
    onArchive: (Email) -> Unit,
    onDelete: (Email) -> Unit,
    onFavorite: (Email) -> Unit
) {
    val emails = remember {
        listOf(
            Email(1, "John Doe", "Meeting Invitation", "You are invited to a meeting tomorrow.", R.drawable.catwhatsapp),
            Email(2, "Jane Doe", "Project Update", "The project status is on track.", R.drawable.catwhatsapp)
        )
    }

    LazyColumn(modifier = modifier.fillMaxSize().padding(4.dp, 0.dp)) {
        items(emails) { email ->
            EmailItem(
                email = email,
                navController = navController, // Passa o NavController para o item
                onArchive = { onArchive(email) },
                onDelete = { onDelete(email) },
                onFavorite = { onFavorite(email) }
            )
            Spacer(modifier = Modifier.height(4.dp))
        }
    }
}