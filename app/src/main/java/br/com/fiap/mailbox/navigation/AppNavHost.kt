package br.com.fiap.mailbox.navigation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import br.com.fiap.mailbox.R
import br.com.fiap.mailbox.model.email.Email
import br.com.fiap.mailbox.ui.screens.appSettings.AppSettingsScreen
import br.com.fiap.mailbox.ui.screens.archived.ArchivedScreen
import br.com.fiap.mailbox.ui.screens.detailsEmail.EmailDetailScreen
import br.com.fiap.mailbox.ui.screens.drafts.DraftsScreen
import br.com.fiap.mailbox.ui.screens.emailCompose.EmailComposeScreen
import br.com.fiap.mailbox.ui.screens.home.HomeScreen
import br.com.fiap.mailbox.ui.screens.search.SearchScreen
import br.com.fiap.mailbox.ui.screens.sent.SentScreen
import br.com.fiap.mailbox.ui.screens.snoozed.SnoozedScreen
import br.com.fiap.mailbox.ui.screens.starred.StarredScreen
import br.com.fiap.mailbox.ui.screens.trash.TrashScreen
import br.com.fiap.mailbox.ui.screens.userSettings.UserSettingsScreen

@Composable
fun AppNavHost(navController: NavHostController, startDestination: String = Routes.Inbox) {
    NavHost(navController = navController, startDestination = startDestination) {
        composable(Routes.Inbox) {
            HomeScreen(navController = navController)
        }
        composable(Routes.Starred) {
            StarredScreen(navController = navController)
        }
        composable(Routes.Snoozed) {
            SnoozedScreen(navController = navController)
        }
        composable(Routes.Sent) {
            SentScreen(navController = navController)
        }
        composable(Routes.Drafts) {
            DraftsScreen(navController = navController)
        }
        composable(Routes.Trash) {
            TrashScreen(navController = navController)
        }
        composable(Routes.Search) {
            SearchScreen(navController = navController)
        }
        composable(Routes.Archived) {
            ArchivedScreen(navController = navController)
        }
        composable(Routes.UserSettings) {
            UserSettingsScreen(navController = navController)
        }
        composable(Routes.AppSettings) {
            AppSettingsScreen(navController = navController)
        }
        composable(Routes.ComposeEmail) {
            EmailComposeScreen(navController = navController)
        }

        composable("emailDetail/{emailId}") { backStackEntry ->
            val emailId = backStackEntry.arguments?.getString("emailId")
            val email = getEmailById(emailId) // Busca o email pelo ID

            if (email != null) {
                EmailDetailScreen(navController = navController, email = email)
            } else {
                // Trate o caso de email não encontrado (pode exibir uma mensagem de erro ou redirecionar)
                Text("Email not found")
            }
        }
    }
}

// Simulação de função para buscar email pelo ID
fun getEmailById(emailId: String?): Email? {
    val emails = listOf(
        Email(1, "John Doe", "Meeting Invitation", "You are invited to a meeting tomorrow.", R.drawable.catwhatsapp),
        Email(2, "Jane Doe", "Project Update", "The project status is on track.", R.drawable.catwhatsapp)
    )

    return emails.find { it.id.toString() == emailId }
}

