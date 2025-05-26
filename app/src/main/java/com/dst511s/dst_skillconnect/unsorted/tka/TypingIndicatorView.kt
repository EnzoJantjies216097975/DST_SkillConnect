package com.dst511s.dst_skillconnect.unsorted.tka

import androidx.compose.animation.core.RepeatMode
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.dst511s.dst_skillconnect.unsorted.data.TypingIndicator

@Composable
fun TypingIndicatorView(typingUsers: List<TypingIndicator>) {
    Row(
        modifier = Modifier.padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Animated typing dots
        repeat(3) { index ->
            val alpha by animateFloatAsState(
                targetValue = if (index % 2 == 0) 0.3f else 1f,
                animationSpec = infiniteRepeatable(
                    animation = tween(600),
                    repeatMode = RepeatMode.Reverse
                ),
                label = "typing_dot_$index"
            )

            Box(
                modifier = Modifier
                    .size(8.dp)
                    .background(
                        MaterialTheme.colorScheme.primary.copy(alpha = alpha),
                        CircleShape
                    )
            )

            if (index < 2) {
                Spacer(modifier = Modifier.width(4.dp))
            }
        }

        Spacer(modifier = Modifier.width(8.dp))

        Text(
            text = "${typingUsers.first().userName} is typing...",
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
        )
    }
}