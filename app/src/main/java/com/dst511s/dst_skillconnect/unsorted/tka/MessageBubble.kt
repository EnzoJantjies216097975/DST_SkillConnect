package com.dst511s.dst_skillconnect.unsorted.tka

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material.icons.Icons
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.dst511s.dst_skillconnect.unsorted.data.Message
import com.dst511s.dst_skillconnect.unsorted.enume.MessageType

@Composable
fun MessageBubble(
    message: Message,
    isOwnMessage: Boolean,
    showSenderName: Boolean
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = if (isOwnMessage) Alignment.End else Alignment.Start
    ) {
        if (showSenderName && !isOwnMessage) {
            Text(
                text = "Sender Name", // Would come from participant data
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f),
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 2.dp)
            )
        }

        Card(
            modifier = Modifier.widthIn(max = 280.dp),
            colors = CardDefaults.cardColors(
                containerColor = if (isOwnMessage) {
                    MaterialTheme.colorScheme.primary
                } else {
                    MaterialTheme.colorScheme.surfaceVariant
                }
            ),
            shape = RoundedCornerShape(
                topStart = 16.dp,
                topEnd = 16.dp,
                bottomStart = if (isOwnMessage) 16.dp else 4.dp,
                bottomEnd = if (isOwnMessage) 4.dp else 16.dp
            )
        ) {
            Column(
                modifier = Modifier.padding(12.dp)
            ) {
                // Reply-to message (if applicable)
                message.replyTo?.let {
                    ReplyPreview(replyToMessageContent = "Original message content...")
                    Spacer(modifier = Modifier.height(4.dp))
                }

                // Message content
                when (message.type) {
                    MessageType.TEXT -> {
                        Text(
                            text = message.content,
                            style = MaterialTheme.typography.bodyMedium,
                            color = if (isOwnMessage) Color.White else MaterialTheme.colorScheme.onSurface
                        )
                    }
                    MessageType.IMAGE -> {
                        // Handle image messages
                        ImageMessage(message = message)
                    }
                    MessageType.FILE -> {
                        // Handle file messages
                        FileMessage(message = message)
                    }
                    MessageType.VOICE -> {
                        // Handle voice messages
                        VoiceMessage(message = message)
                    }
                    MessageType.SYSTEM -> {
                        // Handle system messages
                        SystemMessage(message = message)
                    }
                    else -> {
                        Text(
                            text = message.content,
                            style = MaterialTheme.typography.bodyMedium,
                            color = if (isOwnMessage) Color.White else MaterialTheme.colorScheme.onSurface
                        )
                    }
                }

                // Timestamp and read status
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = formatMessageTime(message.timestamp),
                        style = MaterialTheme.typography.bodySmall,
                        color = if (isOwnMessage) {
                            Color.White.copy(alpha = 0.7f)
                        } else {
                            MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
                        }
                    )

                    if (isOwnMessage) {
                        Spacer(modifier = Modifier.width(4.dp))
                        Icon(
                            imageVector = if (message.isRead) Icons.Default.DoneAll else Icons.Default.Done,
                            contentDescription = if (message.isRead) "Read" else "Delivered",
                            modifier = Modifier.size(14.dp),
                            tint = if (message.isRead) Color.Blue else Color.White.copy(alpha = 0.7f)
                        )
                    }
                }
            }
        }
    }
}