package com.dst511s.dst_skillconnect.screens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NotificationSettingsBottomSheet(
    onDismiss: () -> Unit
) {
    var settings by remember { mutableStateOf(NotificationSettings()) }

    ModalBottomSheet(
        onDismissRequest = onDismiss
    ) {
        LazyColumn(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item {
                Text(
                    text = "Notification Settings",
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Bold
                )
            }

            item {
                Text(
                    text = "Notification Types",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.SemiBold
                )
            }

            item {
                SettingSwitch(
                    title = "Job Matches",
                    description = "Get notified about new job opportunities",
                    checked = settings.jobMatches,
                    onCheckedChange = { settings = settings.copy(jobMatches = it) }
                )
            }

            item {
                SettingSwitch(
                    title = "Application Updates",
                    description = "Updates on your job applications",
                    checked = settings.applicationUpdates,
                    onCheckedChange = { settings = settings.copy(applicationUpdates = it) }
                )
            }

            item {
                SettingSwitch(
                    title = "Workshop Reminders",
                    description = "Reminders for upcoming workshops",
                    checked = settings.workshopReminders,
                    onCheckedChange = { settings = settings.copy(workshopReminders = it) }
                )
            }

            item {
                SettingSwitch(
                    title = "Skill Verifications",
                    description = "Updates on skill assessment results",
                    checked = settings.skillVerifications,
                    onCheckedChange = { settings = settings.copy(skillVerifications = it) }
                )
            }

            item {
                Text(
                    text = "Delivery Methods",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.SemiBold
                )
            }

            item {
                SettingSwitch(
                    title = "Push Notifications",
                    description = "Receive notifications on your device",
                    checked = settings.pushNotifications,
                    onCheckedChange = { settings = settings.copy(pushNotifications = it) }
                )
            }

            item {
                SettingSwitch(
                    title = "Email Notifications",
                    description = "Receive notifications via email",
                    checked = settings.emailNotifications,
                    onCheckedChange = { settings = settings.copy(emailNotifications = it) }
                )
            }

            item {
                Text(
                    text = "Quiet Hours",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.SemiBold
                )
            }

            item {
                SettingSwitch(
                    title = "Enable Quiet Hours",
                    description = "Mute notifications during specified hours",
                    checked = settings.quietHours.enabled,
                    onCheckedChange = {
                        settings = settings.copy(
                            quietHours = settings.quietHours.copy(enabled = it)
                        )
                    }
                )
            }

            if (settings.quietHours.enabled) {
                item {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Column {
                            Text("From")
                            Text(
                                text = settings.quietHours.startTime,
                                style = MaterialTheme.typography.bodyLarge,
                                fontWeight = FontWeight.Medium
                            )
                        }

                        Column {
                            Text("To")
                            Text(
                                text = settings.quietHours.endTime,
                                style = MaterialTheme.typography.bodyLarge,
                                fontWeight = FontWeight.Medium
                            )
                        }
                    }
                }
            }

            item {
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}