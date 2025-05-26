package com.dst511s.dst_skillconnect.unsorted.tka

import androidx.compose.material.icons.Icons
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import com.dst511s.dst_skillconnect.unsorted.data.Conversation
import com.dst511s.dst_skillconnect.unsorted.enume.MessageFilter

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MessagesScreen(
    currentUserId: String,
    onConversationClick: (String) -> Unit,
    onNewMessageClick: () -> Unit
) {
    var conversations by remember { mutableStateOf<List<Conversation>>(emptyList()) }
    var isLoading by remember { mutableStateOf(true) }
    var searchQuery by remember { mutableStateOf("") }
    var selectedFilter by remember { mutableStateOf(MessageFilter.ALL) }

    LaunchedEffect(Unit) {
        // Simulate loading conversations
        delay(1000)
        conversations = generateMockConversations()
        isLoading = false
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Messages") },
                actions = {
                    IconButton(onClick = onNewMessageClick) {
                        Icon(Icons.Default.Edit, contentDescription = "New Message")
                    }
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = onNewMessageClick,
                containerColor = MaterialTheme.colorScheme.primary
            ) {
                Icon(Icons.Default.Add, contentDescription = "New Message")
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            // Search and Filter
            MessageSearchAndFilter(
                searchQuery = searchQuery,
                onSearchQueryChange = { searchQuery = it },
                selectedFilter = selectedFilter,
                onFilterChange = { selectedFilter = it }
            )

            if (isLoading) {
                LoadingMessagesState()
            } else {
                val filteredConversations = filterConversations(
                    conversations, searchQuery, selectedFilter
                )

                if (filteredConversations.isEmpty()) {
                    EmptyMessagesState(filter = selectedFilter)
                } else {
                    ConversationsList(
                        conversations = filteredConversations,
                        currentUserId = currentUserId,
                        onConversationClick = onConversationClick
                    )
                }
            }
        }
    }
}