package br.com.fiap.mailbox.ui.screens.home

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import br.com.fiap.mailbox.ui.components.drawer.DrawerModal
import br.com.fiap.mailbox.viewmodel.EmailViewModel

@Composable
fun HomeScreen(navController: NavController, emailViewModel: EmailViewModel) {
    val emails = emailViewModel.getEmails()
    // Passa o NavController para o DrawerModal
    DrawerModal(navController = navController, emailViewModel = EmailViewModel())
}
