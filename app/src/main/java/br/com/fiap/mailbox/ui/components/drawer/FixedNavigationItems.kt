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

// Composable function for fixed navigation items
@Composable
fun FixedNavigationItems() {
    Column(modifier = Modifier.padding(12.dp, 0.dp)) {
        CustomNavigationDrawerItem(
            labelText = "Inbox",
            badgeContent = "99+",
            icon = ImageVector.vectorResource(id = R.drawable.inbox),
            selected = true, // Make this dynamic if needed
            onClick = { /* Handle navigation */ }
        )
        CustomSpacer(direction = "horizontal", isFull = true)
        CustomNavigationDrawerItem(
            labelText = "Starred",
            badgeContent = "2",
            icon = ImageVector.vectorResource(id = R.drawable.star),
            selected = false,
            onClick = { /* Handle navigation */ }
        )
        CustomSpacer(direction = "horizontal", isFull = true)
        CustomNavigationDrawerItem(
            labelText = "Snoozed",
            badgeContent = "5",
            icon = ImageVector.vectorResource(id = R.drawable.clock),
            selected = false,
            onClick = { /* Handle navigation */ }
        )
        CustomSpacer(direction = "horizontal", isFull = true)
        CustomNavigationDrawerItem(
            labelText = "Sent",
            badgeContent = "18",
            icon = ImageVector.vectorResource(id = R.drawable.send_horizontal),
            selected = false,
            onClick = { /* Handle navigation */ }
        )
        CustomSpacer(direction = "horizontal", isFull = true)
        CustomNavigationDrawerItem(
            labelText = "Drafts",
            badgeContent = "1",
            icon = ImageVector.vectorResource(id = R.drawable.file),
            selected = false,
            onClick = { /* Handle navigation */ }
        )
        CustomSpacer(direction = "horizontal", isFull = true)
        CustomNavigationDrawerItem(
            labelText = "Trash",
            badgeContent = "99+",
            icon = ImageVector.vectorResource(id = R.drawable.trash_2),
            selected = false,
            onClick = { /* Handle navigation */ }
        )
        CustomSpacer(direction = "horizontal", isFull = true)
        CustomNavigationDrawerItem(
            labelText = "Archived",
            badgeContent = "9",
            icon = ImageVector.vectorResource(id = R.drawable.archive_restore),
            selected = false,
            onClick = { /* Handle navigation */ }
        )
        // Add the rest of your fixed items (Drafts, Trash, Archived) here in a similar manner
    }
}