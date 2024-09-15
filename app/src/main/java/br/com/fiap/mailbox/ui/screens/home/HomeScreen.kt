package br.com.fiap.mailbox.ui.screens.home

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import br.com.fiap.mailbox.ui.components.drawer.DrawerModal

@Composable
fun HomeScreen(navController: NavController) {
    // Passa o NavController para o DrawerModal
    DrawerModal(navController = navController)
}
