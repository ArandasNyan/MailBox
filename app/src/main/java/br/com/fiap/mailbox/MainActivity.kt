package br.com.fiap.mailbox

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import br.com.fiap.mailbox.navigation.AppNavHost
import br.com.fiap.mailbox.ui.theme.MailBoxTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MailBoxTheme {
                // Inicializa o NavController no nível da Activity
                val navController = rememberNavController()

                // Adiciona o AppNavHost para gerenciar a navegação
                AppNavHost(navController = navController)
            }
        }
    }
}

