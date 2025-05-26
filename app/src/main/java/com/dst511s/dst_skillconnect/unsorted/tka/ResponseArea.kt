package com.dst511s.dst_skillconnect.unsorted.tka

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Draw
import androidx.compose.material.icons.filled.Mic
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.dst511s.dst_skillconnect.unsorted.enume.QuestionType

@Composable
fun ResponseArea(
    response: String,
    onResponseChange: (String) -> Unit,
    isRecording: Boolean,
    onToggleRecording: () -> Unit,
    questionType: QuestionType
) {
    Column {
        when (questionType) {
            QuestionType.OPEN_ENDED -> {
                OutlinedTextField(
                    value = response,
                    onValueChange = onResponseChange,
                    label = { Text("Your response") },
                    placeholder = { Text("Type your answer here...") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp),
                    maxLines = 10
                )
            }

            QuestionType.CODING -> {
                OutlinedTextField(
                    value = response,
                    onValueChange = onResponseChange,
                    label = { Text("Your code") },
                    placeholder = { Text("Write your code here...") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(300.dp),
                    maxLines = 15
                )
            }

            QuestionType.MULTIPLE_CHOICE -> {
                // Handle multiple choice questions
                MultipleChoiceResponse(
                    selectedOption = response,
                    onOptionSelected = onResponseChange
                )
            }

            QuestionType.WHITEBOARD -> {
                // Placeholder for whiteboard drawing area
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(300.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.surfaceVariant
                    )
                ) {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Icon(
                                imageVector = Icons.Default.Draw,
                                contentDescription = null,
                                modifier = Modifier.size(48.dp),
                                tint = MaterialTheme.colorScheme.onSurfaceVariant
                            )

                            Text(
                                text = "Whiteboard area",
                                style = MaterialTheme.typography.bodyLarge,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )

                            Text(
                                text = "Draw your solution here",
                                style = MaterialTheme.typography.bodyMedium,
                                color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.7f)
                            )
                        }
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Recording controls
        Card(
            colors = CardDefaults.cardColors(
                containerColor = if (isRecording) {
                    Color(0xFFF44336).copy(alpha = 0.1f)
                } else {
                    MaterialTheme.colorScheme.surfaceVariant
                }
            )
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.Mic,
                        contentDescription = null,
                        tint = if (isRecording) Color(0xFFF44336) else MaterialTheme.colorScheme.onSurfaceVariant
                    )

                    Spacer(modifier = Modifier.width(8.dp))

                    Text(
                        text = if (isRecording) "Recording your response..." else "Practice speaking your answer",
                        style = MaterialTheme.typography.bodyMedium,
                        color = if (isRecording) Color(0xFFF44336) else MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }

                Button(
                    onClick = onToggleRecording,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (isRecording) Color(0xFFF44336) else MaterialTheme.colorScheme.primary
                    )
                ) {
                    Text(if (isRecording) "Stop" else "Record")
                }
            }
        }
    }
}
