package br.com.fiap.mailbox.ui.components.drawer

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import br.com.fiap.mailbox.R
import br.com.fiap.mailbox.ui.components.global.CustomSpacer
import br.com.fiap.mailbox.navigation.Routes

// Composable function for fixed navigation items
@Composable
fun FixedNavigationItems(onItemClick: (String) -> Unit) {
    Column(modifier = Modifier.padding(12.dp, 0.dp)) {
        CustomNavigationDrawerItem(
            labelText = "Inbox",
            badgeContent = "99+",
            icon = ImageVector.vectorResource(id = R.drawable.inbox),
            selected = true, // Make this dynamic if needed
            onClick = { onItemClick(Routes.Inbox) }
        )
        CustomSpacer(direction = "horizontal", isFull = true)
        CustomNavigationDrawerItem(
            labelText = "Starred",
            badgeContent = "2",
            icon = ImageVector.vectorResource(id = R.drawable.star),
            selected = false,
            onClick = { onItemClick(Routes.Starred) }
        )
        CustomSpacer(direction = "horizontal", isFull = true)
        CustomNavigationDrawerItem(
            labelText = "Snoozed",
            badgeContent = "5",
            icon = ImageVector.vectorResource(id = R.drawable.clock),
            selected = false,
            onClick = { onItemClick(Routes.Snoozed) }
        )
        CustomSpacer(direction = "horizontal", isFull = true)
        CustomNavigationDrawerItem(
            labelText = "Sent",
            badgeContent = "18",
            icon = ImageVector.vectorResource(id = R.drawable.send_horizontal),
            selected = false,
            onClick = { onItemClick(Routes.Sent) }
        )
        CustomSpacer(direction = "horizontal", isFull = true)
        CustomNavigationDrawerItem(
            labelText = "Drafts",
            badgeContent = "1",
            icon = ImageVector.vectorResource(id = R.drawable.file),
            selected = false,
            onClick = { onItemClick(Routes.Drafts) }
        )
        CustomSpacer(direction = "horizontal", isFull = true)
        CustomNavigationDrawerItem(
            labelText = "Trash",
            badgeContent = "99+",
            icon = ImageVector.vectorResource(id = R.drawable.trash_2),
            selected = false,
            onClick = { onItemClick(Routes.Trash) }
        )
        CustomSpacer(direction = "horizontal", isFull = true)
        CustomNavigationDrawerItem(
            labelText = "Archived",
            badgeContent = "9",
            icon = ImageVector.vectorResource(id = R.drawable.archive_restore),
            selected = false,
            onClick = { onItemClick(Routes.Archived) }
        )
        // Add the rest of your fixed items (Drafts, Trash, Archived) here in a similar manner
    }
}