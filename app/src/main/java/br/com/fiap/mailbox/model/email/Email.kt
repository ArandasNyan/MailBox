package br.com.fiap.mailbox.model.email

import androidx.annotation.DrawableRes

data class Email(
    val id: Int,
    val senderName: String,
    val senderEmail: String,
    val emailTitle: String,
    val content: String,
    val date: String,
    @DrawableRes val avatar: Int, // Drawable resource ID for the avatar
    val isStarred: Boolean = false // Optional: whether the email is marked as starred
)
