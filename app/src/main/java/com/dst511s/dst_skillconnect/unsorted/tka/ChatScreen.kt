package com.dst511s.dst_skillconnect.unsorted.tka

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dst511s.dst_skillconnect.unsorted.data.Conversation
import com.dst511s.dst_skillconnect.unsorted.data.Message
import com.dst511s.dst_skillconnect.unsorted.data.TypingIndicator
import com.dst511s.dst_skillconnect.unsorted.enume.MessageType

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChatScreen(
    conversationId: String,
    currentUserId: String,
    onNavigateBack: () -> Unit
) {
    var messages by remember { mutableStateOf<List<Message>>(emptyList()) }
    var messageText by remember { mutableStateOf("") }
    var conversation by remember { mutableStateOf<Conversation?>(null) }
    var isTyping by remember { mutableStateOf(false) }
    var typingUsers by remember { mutableStateOf<List<TypingIndicator>>(emptyList()) }

    val listState = rememberLazyListState()

    LaunchedEffect(conversationId) {
        // Load conversation and messages
        conversation = generateMockConversation(conversationId)
        messages = generateMockMessages(conversationId, currentUserId)

        // Auto-scroll to bottom
        listState.animateScrollToItem(messages.size)
    }

    val otherParticipant = conversation?.participants?.firstOrNull { it.userId != currentUserId }

    Scaffold(
        topBar = {
            ChatTopBar(
                participant = otherParticipant,
                onNavigateBack = onNavigateBack,
                onCallClick = { /* Handle voice call */ },
                onVideoCallClick = { /* Handle video call */ },
                onInfoClick = { /* Show participant info */ }
            )
        },
        bottomBar = {
            ChatBottomBar(
                messageText = messageText,
                onMessageTextChange = { messageText = it },
                onSendMessage = {
                    if (messageText.isNotBlank()) {
                        val newMessage = Message(
                            id = "msg_${System.currentTimeMillis()}",
                            conversationId = conversationId,
                            senderId = currentUserId,
                            content = messageText.trim(),
                            timestamp = System.currentTimeMillis(),
                            type = MessageType.TEXT
                        )
                        messages = messages + newMessage
                        messageText = ""

                        // Auto-scroll to bottom
                        LaunchedEffect(messages.size) {
                            listState.animateScrollToItem(messages.size - 1)
                        }
                    }
                },
                onAttachFile = { /* Handle file attachment */ },
                onRecordVoice = { /* Handle voice recording */ }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            // Messages list
            LazyColumn(
                state = listState,
                modifier = Modifier.weight(1f),
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(messages) { message ->
                    MessageBubble(
                        message = message,
                        isOwnMessage = message.senderId == currentUserId,
                        showSenderName = false // Only needed for group chats
                    )
                }
            }

            // Typing indicator
            if (typingUsers.isNotEmpty()) {
                TypingIndicatorView(typingUsers = typingUsers)
            }
        }
    }
}
