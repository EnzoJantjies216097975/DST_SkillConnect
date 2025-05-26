package com.dst511s.dst_skillconnect.unsorted.tka

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.material.icons.filled.AttachFile
import androidx.compose.material.icons.filled.Mic
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ChatBottomBar(
    messageText: String,
    onMessageTextChange: (String) -> Unit,
    onSendMessage: @Composable () -> Unit,
    onAttachFile: () -> Unit,
    onRecordVoice: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.Bottom
    ) {
        // Attachment button
        IconButton(onClick = onAttachFile) {
            Icon(Icons.Default.AttachFile, contentDescription = "Attach file")
        }

        // Message input
        OutlinedTextField(
            value = messageText,
            onValueChange = onMessageTextChange,
            placeholder = { Text("Type a message...") },
            modifier = Modifier.weight(1f),
            shape = RoundedCornerShape(24.dp),
            maxLines = 4,
            trailingIcon = {
                if (messageText.isBlank()) {
                    IconButton(onClick = onRecordVoice) {
                        Icon(Icons.Default.Mic, contentDescription = "Record voice")
                    }
                }
            }
        )

        Spacer(modifier = Modifier.width(8.dp))

        // Send button
        FloatingActionButton(
            onClick = onSendMessage,
            modifier = Modifier.size(48.dp),
            containerColor = if (messageText.isNotBlank()) {
                MaterialTheme.colorScheme.primary
            } else {
                MaterialTheme.colorScheme.surfaceVariant
            }
        ) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.Send,
                contentDescription = "Send",
                tint = if (messageText.isNotBlank()) {
                    Color.White
                } else {
                    MaterialTheme.colorScheme.onSurfaceVariant
                }
            )
        }
    }
}


