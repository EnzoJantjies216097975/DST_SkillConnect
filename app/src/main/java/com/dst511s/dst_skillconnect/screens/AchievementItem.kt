package com.dst511s.dst_skillconnect.screens

@Composable
fun AchievementItem(achievement: CompanyAchievement) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = when (achievement.type) {
                AchievementType.AWARD -> Icons.Default.EmojiEvents
                AchievementType.CERTIFICATION -> Icons.Default.VerifiedUser
                AchievementType.MILESTONE -> Icons.Default.Flag
                AchievementType.RECOGNITION -> Icons.Default.Star
            },
            contentDescription = null,
            modifier = Modifier.size(24.dp),
            tint = Color(0xFFFFD700)
        )

        Spacer(modifier = Modifier.width(12.dp))

        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = achievement.title,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.SemiBold
            )

            Text(
                text = achievement.description,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.8f)
            )
        }

        Text(
            text = achievement.year.toString(),
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.primary,
            fontWeight = FontWeight.Medium
        )
    }
}