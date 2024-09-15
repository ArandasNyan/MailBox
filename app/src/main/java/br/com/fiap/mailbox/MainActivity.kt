package br.com.fiap.mailbox

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import br.com.fiap.mailbox.ui.screens.home.App
import br.com.fiap.mailbox.ui.theme.MailBoxTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MailBoxTheme {
                App()
            }
        }
    }
}

