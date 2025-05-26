package com.dst511s.dst_skillconnect.unsorted.tka

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.VideoCall
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.dst511s.dst_skillconnect.unsorted.data.ConversationParticipant

@Composable
fun ChatTopBar(
    participant: ConversationParticipant?,
    onNavigateBack: () -> Unit,
    onCallClick: () -> Unit,
    onVideoCallClick: () -> Unit,
    onInfoClick: () -> Unit
) {
    TopAppBar(
        title = {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                AsyncImage(
                    model = participant?.profileImageUrl,
                    contentDescription = "${participant?.name} profile",
                    modifier = Modifier
                        .size(32.dp)
                        .clip(CircleShape),
                    error = {
                        Box(
                            modifier = Modifier
                                .size(32.dp)
                                .background(MaterialTheme.colorScheme.primary, CircleShape),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = participant?.name?.take(1) ?: "?",
                                color = Color.White,
                                style = MaterialTheme.typography.bodyMedium
                            )
                        }
                    }
                )

                Spacer(modifier = Modifier.width(12.dp))

                Column {
                    Text(
                        text = participant?.name ?: "Unknown",
                        style = MaterialTheme.typography.titleMedium
                    )

                    if (participant?.isOnline == true) {
                        Text(
                            text = "Online",
                            style = MaterialTheme.typography.bodySmall,
                            color = Color.Green
                        )
                    } else {
                        participant?.lastSeen?.let { lastSeen ->
                            Text(
                                text = "Last seen ${formatMessageTime(lastSeen)}",
                                style = MaterialTheme.typography.bodySmall,
                                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
                            )
                        }
                    }
                }
            }
        },
        navigationIcon = {
            IconButton(onClick = onNavigateBack) {
                Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
            }
        },
        actions = {
            IconButton(onClick = onCallClick) {
                Icon(Icons.Default.Call, contentDescription = "Voice Call")
            }
            IconButton(onClick = onVideoCallClick) {
                Icon(Icons.Default.VideoCall, contentDescription = "Video Call")
            }
            IconButton(onClick = onInfoClick) {
                Icon(Icons.Default.Info, contentDescription = "Info")
            }
        }
    )
}