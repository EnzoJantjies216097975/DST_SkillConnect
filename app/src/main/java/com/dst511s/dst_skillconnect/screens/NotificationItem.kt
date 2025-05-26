package com.dst511s.dst_skillconnect.screens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NotificationItem(
    notification: Notification,
    onClick: () -> Unit,
    onDismiss: () -> Unit
) {
    val dismissState = rememberDismissState(
        confirmValueChange = {
            if (it == DismissValue.DismissedToEnd || it == DismissValue.DismissedToStart) {
                onDismiss()
                true
            } else {
                false
            }
        }
    )

    SwipeToDismiss(
        state = dismissState,
        directions = setOf(DismissDirection.StartToEnd, DismissDirection.EndToStart),
        background = {
            DismissBackground(dismissState = dismissState)
        },
        dismissContent = {
            NotificationContent(
                notification = notification,
                onClick = onClick
            )
        }
    )
}