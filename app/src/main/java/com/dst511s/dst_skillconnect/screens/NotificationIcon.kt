package com.dst511s.dst_skillconnect.screens

@Composable
fun NotificationIcon(
    type: NotificationType,
    priority: NotificationPriority
) {
    val (icon, backgroundColor) = when (type) {
        NotificationType.JOB_MATCH -> Icons.Default.Work to Color(0xFF4CAF50)
        NotificationType.APPLICATION_UPDATE -> Icons.Default.Assignment to Color(0xFF2196F3)
        NotificationType.WORKSHOP_REMINDER -> Icons.Default.School to Color(0xFF9C27B0)
        NotificationType.SKILL_VERIFICATION -> Icons.Default.Verified to Color(0xFFFF9800)
        NotificationType.COMPANY_UPDATE -> Icons.Default.Business to Color(0xFF607D8B)
        NotificationType.MESSAGE -> Icons.Default.Message to Color(0xFF795548)
        NotificationType.SYSTEM_UPDATE -> Icons.Default.SystemUpdate to Color(0xFF9E9E9E)
        NotificationType.ACHIEVEMENT -> Icons.Default.EmojiEvents to Color(0xFFFFD700)
    }

    Box(
        modifier = Modifier
            .size(40.dp)
            .background(
                backgroundColor.copy(alpha = 0.2f),
                CircleShape
            ),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = backgroundColor,
            modifier = Modifier.size(20.dp)
        )

        // Priority indicator
        if (priority == NotificationPriority.HIGH || priority == NotificationPriority.URGENT) {
            Box(
                modifier = Modifier
                    .size(12.dp)
                    .background(
                        if (priority == NotificationPriority.URGENT) Color.Red else Color(0xFFFF9800),
                        CircleShape
                    )
                    .align(Alignment.TopEnd)
            )
        }
    }
}