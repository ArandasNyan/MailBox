package br.com.fiap.mailbox.ui.components.email

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.mailbox.model.email.Email

@Composable
fun EmailItem(
    email: Email,
    onArchive: () -> Unit,
    onDelete: () -> Unit,
    onFavorite: () -> Unit,
    navController: NavController
) {
    var showMenu by remember { mutableStateOf(false) }
    var clickPosition by remember { mutableStateOf(Offset.Zero) }
    val density = LocalDensity.current

    // Remover quebras de linha e espaços desnecessários
    val previewContent = email.content.replace("\\s+".toRegex(), " ").trim()

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Transparent, shape = RoundedCornerShape(8.dp))
            .pointerInput(Unit) {
                detectTapGestures(
                    onPress = { /* Placeholder for press */ },
                    onTap = {
                        // Ao clicar no item, navega para a página de detalhes
                        navController.navigate("emailDetail/${email.id}")
                    },
                    onLongPress = { offset ->
                        clickPosition = offset
                        showMenu = true
                    }
                )
            }
            .padding(6.dp, 4.dp, 12.dp, 4.dp)
    ) {
        Row(
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            // Avatar Image
            Image(
                painter = painterResource(id = email.avatar),
                contentDescription = "Avatar",
                modifier = Modifier
                    .size(48.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.width(8.dp))

            // Email Information
            Column(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = email.senderName,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary
                )
                Text(
                    text = email.emailTitle,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.secondary
                )
                Text(
                    text = previewContent,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    fontSize = 14.sp,
                    color = MaterialTheme.colorScheme.onSecondary
                )
            }

            // Dropdown Menu for actions (Archive, Delete, Favorite)
            DropdownMenu(
                expanded = showMenu,
                onDismissRequest = { showMenu = false },
                offset = with(density) {
                    DpOffset(clickPosition.x.toDp(), clickPosition.y.toDp())
                }
            ) {
                DropdownMenuItem(
                    text = { Text("Archive") },
                    onClick = {
                        onArchive()
                        showMenu = false
                    },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                            contentDescription = null
                        )
                    }
                )
                DropdownMenuItem(
                    text = { Text("Delete") },
                    onClick = {
                        onDelete()
                        showMenu = false
                    },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Delete,
                            contentDescription = null
                        )
                    }
                )
                DropdownMenuItem(
                    text = { Text("Favorite") },
                    onClick = {
                        onFavorite()
                        showMenu = false
                    },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Star,
                            contentDescription = null
                        )
                    }
                )
            }
        }
    }
}