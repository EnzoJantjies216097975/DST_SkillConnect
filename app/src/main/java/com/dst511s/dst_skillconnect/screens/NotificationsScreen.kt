package com.dst511s.dst_skillconnect.screens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NotificationsScreen(
    notificationManager: NotificationManager = remember { NotificationManager() },
    onNavigateBack: () -> Unit,
    onNotificationAction: (NotificationActionData) -> Unit
) {
    var selectedCategory by remember { mutableStateOf<NotificationCategory?>(null) }
    var showSettings by remember { mutableStateOf(false) }

    // Generate mock notifications on first load
    LaunchedEffect(Unit) {
        generateMockNotifications().forEach { notification ->
            notificationManager.addNotification(notification)
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = if (selectedCategory != null) {
                            selectedCategory!!.name.lowercase().capitalize()
                        } else {
                            "Notifications"
                        }
                    )
                },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                },
                actions = {
                    IconButton(onClick = { showSettings = true }) {
                        Icon(Icons.Default.Settings, contentDescription = "Settings")
                    }

                    if (notificationManager.unreadCount.value > 0) {
                        IconButton(onClick = { notificationManager.markAllAsRead() }) {
                            Icon(Icons.Default.MarkEmailRead, contentDescription = "Mark all read")
                        }
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            // Category Filter
            NotificationCategoryFilter(
                selectedCategory = selectedCategory,
                onCategorySelected = { selectedCategory = it },
                notificationManager = notificationManager
            )

            // Notifications List
            val filteredNotifications = if (selectedCategory != null) {
                notificationManager.getNotificationsByCategory(selectedCategory!!)
            } else {
                notificationManager.notifications
            }

            if (filteredNotifications.isEmpty()) {
                EmptyNotificationsState(
                    category = selectedCategory,
                    modifier = Modifier.fillMaxSize()
                )
            } else {
                LazyColumn(
                    contentPadding = PaddingValues(vertical = 8.dp),
                    verticalArrangement = Arrangement.spacedBy(1.dp)
                ) {
                    items(
                        items = filteredNotifications,
                        key = { it.id }
                    ) { notification ->
                        NotificationItem(
                            notification = notification,
                            onClick = {
                                notificationManager.markAsRead(notification.id)
                                notification.actionData?.let { actionData ->
                                    onNotificationAction(actionData)
                                }
                            },
                            onDismiss = { notificationManager.deleteNotification(notification.id) }
                        )
                    }
                }
            }
        }
    }

    // Settings Bottom Sheet
    if (showSettings) {
        NotificationSettingsBottomSheet(
            onDismiss = { showSettings = false }
        )
    }
}