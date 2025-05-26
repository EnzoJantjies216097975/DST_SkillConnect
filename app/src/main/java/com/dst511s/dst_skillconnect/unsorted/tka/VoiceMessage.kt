package com.dst511s.dst_skillconnect.unsorted.tka

import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.dst511s.dst_skillconnect.unsorted.data.Message

@Composable
fun VoiceMessage(message: Message) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(8.dp)
    ) {
        IconButton(onClick = { /* Play/pause voice message */ }) {
            Icon(
                imageVector = Icons.Default.PlayArrow,
                contentDescription = "Play"
            )
        }

        // Waveform visualization (simplified)
        LinearProgressIndicator(
            progress = { 0.3f },
            modifier = Modifier
                .weight(1f)
                .height(4.dp),
            color = MaterialTheme.colorScheme.primary
        )

        Spacer(modifier = Modifier.width(8.dp))

        Text(
            text = "0:15",
            style = MaterialTheme.typography.bodySmall
        )
    }
}
