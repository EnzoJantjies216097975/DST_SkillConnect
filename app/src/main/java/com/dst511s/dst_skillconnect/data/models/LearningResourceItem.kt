package com.dst511s.dst_skillconnect.data.models

@Composable
fun LearningResourceItem(resource: LearningResource) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = when (resource.type) {
                ResourceType.COURSE -> Icons.Default.PlayCircle
                ResourceType.WORKSHOP -> Icons.Default.Group
                ResourceType.TUTORIAL -> Icons.Default.VideoLibrary
                ResourceType.BOOK -> Icons.Default.MenuBook
                ResourceType.CERTIFICATION -> Icons.Default.Badge
                ResourceType.BOOTCAMP -> Icons.Default.School
            },
            contentDescription = null,
            modifier = Modifier.size(16.dp),
            tint = MaterialTheme.colorScheme.primary
        )

        Spacer(modifier = Modifier.width(8.dp))

        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = resource.title,
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Medium
            )

            Row {
                Text(
                    text = "${resource.provider} • ${resource.duration} • ${resource.cost}",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
                )
            }
        }

        if (resource.rating > 0) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = Icons.Default.Star,
                    contentDescription = null,
                    modifier = Modifier.size(12.dp),
                    tint = Color(0xFFFFD700)
                )
                Text(
                    text = resource.rating.toString(),
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier.padding(start = 2.dp)
                )
            }
        }
    }
}