package br.com.fiap.mailbox.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import br.com.fiap.mailbox.model.email.Email
import br.com.fiap.mailbox.R

class EmailViewModel : ViewModel() {
    // Use mutableStateListOf para que a lista seja observável e reativa no Compose
    private val _emails = mutableStateListOf(
        Email(
            id = 1,
            senderName = "John Doe",
            senderEmail = "john.doe@example.com",
            emailTitle = "Meeting Invitation",
            content = """
                Hi there,
                
                You are invited to a meeting tomorrow. Please review the agenda and prepare your updates.
                
                Best regards,
                John
            """.trimIndent(),
            date = "2024-09-17",
            avatar = R.drawable.catwhatsapp,
            isStarred = false
        ),
        Email(
            id = 2,
            senderName = "Jane Smith",
            senderEmail = "jane.smith@example.com",
            emailTitle = "Project Update",
            content = """
                Dear Team,
                
                Here is the latest update on the project status. We are on track to meet the deadline.
                
                Regards,
                Jane
            """.trimIndent(),
            date = "2024-09-18",
            avatar = R.drawable.catwhatsapp,
            isStarred = true
        )
    )

    // Função para acessar a lista de emails
    fun getEmails(): List<Email> = _emails

    // Função para acessar um email específico pelo ID
    fun getEmailById(id: Int): Email? = _emails.find { it.id == id }

    // Função para marcar ou desmarcar como favorito
    fun toggleStarred(emailId: Int) {
        val index = _emails.indexOfFirst { it.id == emailId }
        if (index != -1) {
            val email = _emails[index]
            _emails[index] = email.copy(isStarred = !email.isStarred) // Atualiza o estado de "starred"
        }
    }
}