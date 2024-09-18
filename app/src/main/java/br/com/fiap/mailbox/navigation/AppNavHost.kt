package br.com.fiap.mailbox.navigation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
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
import br.com.fiap.mailbox.viewmodel.EmailViewModel

@Composable
fun AppNavHost(
    navController: NavHostController,
    startDestination: String = Routes.Inbox,
    emailViewModel: EmailViewModel = viewModel() // Usando o ViewModel padrão do Compose
) {
    NavHost(navController = navController, startDestination = startDestination) {
        composable(Routes.Inbox) {
            HomeScreen(navController = navController, emailViewModel = emailViewModel)
        }
        composable(Routes.Starred) {
            StarredScreen(navController = navController, emailViewModel = emailViewModel)
        }
        composable(Routes.Snoozed) {
            SnoozedScreen(navController = navController, emailViewModel = emailViewModel)
        }
        composable(Routes.Sent) {
            SentScreen(navController = navController, emailViewModel = emailViewModel)
        }
        composable(Routes.Drafts) {
            DraftsScreen(navController = navController, emailViewModel = emailViewModel)
        }
        composable(Routes.Trash) {
            TrashScreen(navController = navController, emailViewModel = emailViewModel)
        }
        composable(Routes.Search) {
            SearchScreen(navController = navController, emailViewModel = emailViewModel)
        }
        composable(Routes.Archived) {
            ArchivedScreen(navController = navController, emailViewModel = emailViewModel)
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
            val emailId = backStackEntry.arguments?.getString("emailId")?.toIntOrNull()
            val email = emailId?.let { emailViewModel.getEmailById(it) }

            if (email != null) {
                EmailDetailScreen(navController = navController, email = email)
            } else {
                // Trate o caso de email não encontrado (pode exibir uma mensagem de erro ou redirecionar)
                Text("Email not found")
            }
        }
    }
}
