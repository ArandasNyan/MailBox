package br.com.fiap.mailbox.model.email

data class Email(
    val id: Int,
    val senderName: String,
    val emailTitle: String,
    val content: String,
    val avatar: Int
)