package br.com.fiap.mailbox.ui.screens.detailsEmail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.mailbox.R
import br.com.fiap.mailbox.model.email.Email

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EmailDetailScreen(
    navController: NavController,
    email: Email
) {
    var isFavorite by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(Color.Transparent),
                title = {
                    Text(
                        "Message Details",
                        color = MaterialTheme.colorScheme.secondary,
                        style = MaterialTheme.typography.headlineSmall.copy(
                            fontWeight = FontWeight.Medium
                        )
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            ImageVector.vectorResource(R.drawable.chevron_left),
                            contentDescription = "Back",
                            tint = MaterialTheme.colorScheme.tertiary
                        )
                    }
                },
                actions = {
                    IconButton(onClick = {
                        /* Todo */
                    }) {
                        Icon(
                            ImageVector.vectorResource(R.drawable.ellipsis_vertical),
                            contentDescription = "More actions",
                            tint = MaterialTheme.colorScheme.tertiary
                        )
                    }
                },
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
                .verticalScroll(rememberScrollState())  // Permitir scroll no conteúdo do email
        ) {
            // Remetente
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Avatar
                Image(
                    painter = painterResource(id = email.avatar),
                    contentDescription = "Avatar",
                    modifier = Modifier
                        .size(48.dp)
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop
                )

                Spacer(modifier = Modifier.width(8.dp))

                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = email.senderName,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.primary
                    )
                    Text(
                        text = email.senderEmail,
                        fontSize = 14.sp,
                        color = MaterialTheme.colorScheme.secondary
                    )
                }

                IconButton(onClick = {
                    isFavorite = !isFavorite // Alterna o estado entre favorito e não favorito
                }) {
                    Icon(
                        ImageVector.vectorResource(
                            if (isFavorite) R.drawable.star_filled else R.drawable.star
                        ), // Alterna entre star e star_filled
                        contentDescription = if (isFavorite) "Unfavorite" else "Favorite",
                        tint = if (isFavorite) Color.Yellow else MaterialTheme.colorScheme.tertiary
                    )
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Título do email
            Text(
                text = email.emailTitle,
                fontSize = 22.sp,
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colorScheme.secondary
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Conteúdo do email
            Text(
                text = email.content,
                fontSize = 16.sp,
                color = MaterialTheme.colorScheme.onSurface
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Data do email
            Text(
                text = "Sent on ${email.date}",
                fontSize = 14.sp,
                color = MaterialTheme.colorScheme.onBackground
            )
        }
    }
}
