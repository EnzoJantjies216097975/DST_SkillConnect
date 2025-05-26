package com.dst511s.dst_skillconnect.features.workshops.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Code
import androidx.compose.material.icons.filled.Description
import androidx.compose.material.icons.filled.FilterList
import androidx.compose.material.icons.filled.Group
import androidx.compose.material.icons.filled.People
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Web
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dst511s.dst_skillconnect.common.components.cards.WorkshopCard
import com.dst511s.dst_skillconnect.core.data.models.workshop.Workshop
import com.dst511s.dst_skillconnect.ui.theme.DST_SkillConnectTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WorkshopsScreen(
    onNavigateBack: () -> Unit,
    onWorkshopClick: (String) -> Unit
) {
    var searchQuery by remember { mutableStateOf("") }

    val workshops = remember {
        listOf(
            Workshop(
                id = "1",
                title = "Advanced JavaScript Workshop",
                description = "Learn modern JS techniques and frameworks",
                date = "May 15, 2025",
                time = "10:00 AM - 12:00 PM",
                location = "Online",
                isOnline = true,
                icon = Icons.Default.Code,
                iconBackgroundColor = Color(0xFF3866F2),
                isRegistered = false
            ),
            Workshop(
                id = "2",
                title = "Resume Building Masterclass",
                description = "Create a standout CV for the digital age",
                date = "May 20, 2025",
                time = "2:00 PM - 4:00 PM",
                location = "Windhoek Innovation Hub",
                isOnline = false,
                icon = Icons.Default.Description,
                iconBackgroundColor = Color(0xFF9C27B0),
                isRegistered = true
            ),
            Workshop(
                id = "3",
                title = "Tech Interview Preparation",
                description = "Practice common interview questions and scenarios",
                date = "June 5, 2025",
                time = "3:00 PM - 5:00 PM",
                location = "Online",
                isOnline = true,
                icon = Icons.Default.People,
                iconBackgroundColor = Color(0xFF4CAF50),
                isRegistered = false
            ),
            Workshop(
                id = "4",
                title = "Introduction to React",
                description = "Learn the basics of React and build your first app",
                date = "May 25, 2025",
                time = "1:00 PM - 4:00 PM",
                location = "Online",
                isOnline = true,
                icon = Icons.Default.Web,
                iconBackgroundColor = Color(0xFF00BCD4),
                isRegistered = false
            ),
            Workshop(
                id = "5",
                title = "Networking for Professionals",
                description = "Build your professional network effectively",
                date = "June 10, 2025",
                time = "5:30 PM - 7:30 PM",
                location = "Namibia Business Hub",
                isOnline = false,
                icon = Icons.Default.Group,
                iconBackgroundColor = Color(0xFFFF9800),
                isRegistered = false
            )
        )
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Workshops & Training") },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                },
                actions = {
                    IconButton(onClick = { /* Open filters */ }) {
                        Icon(
                            imageVector = Icons.Default.FilterList,
                            contentDescription = "Filter"
                        )
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
            // Search bar
            OutlinedTextField(
                value = searchQuery,
                onValueChange = { searchQuery = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                placeholder = { Text("Search workshops...") },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "Search"
                    )
                },
                trailingIcon = {
                    if (searchQuery.isNotEmpty()) {
                        IconButton(onClick = { searchQuery = "" }) {
                            Icon(
                                imageVector = Icons.Default.Clear,
                                contentDescription = "Clear"
                            )
                        }
                    }
                },
                shape = RoundedCornerShape(24.dp),
                singleLine = true
            )

            // Filter chips
            SingleChoiceSegmentedButtonRow(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .fillMaxWidth()
            ) {
                SegmentedButton(
                    selected = true,
                    onClick = { /* Handle filter change */ },
                    shape = SegmentedButtonDefaults.itemShape(index = 0, count = 4),
                    label = { Text("All") }
                )

                SegmentedButton(
                    selected = false,
                    onClick = { /* Handle filter change */ },
                    shape = SegmentedButtonDefaults.itemShape(index = 1, count = 4),
                    label = { Text("Online") }
                )

                SegmentedButton(
                    selected = false,
                    onClick = { /* Handle filter change */ },
                    shape = SegmentedButtonDefaults.itemShape(index = 2, count = 4),
                    label = { Text("In-Person") }
                )

                SegmentedButton(
                    selected = false,
                    onClick = { /* Handle filter change */ },
                    shape = SegmentedButtonDefaults.itemShape(index = 3, count = 4),
                    label = { Text("Registered") }
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Workshop list
            LazyColumn {
                item {
                    Text(
                        text = "Upcoming Workshops",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
                    )
                }

                items(workshops) { workshop ->
                    WorkshopCard(
                        workshop = workshop,
                        onClick = { onWorkshopClick(workshop.id) }
                    )
                }

                item {
                    Spacer(modifier = Modifier.height(80.dp))
                }
            }
        }
    }
}

// WorkshopsScreen Preview
@Preview(showBackground = true)
@Composable
fun WorkshopsScreenPreview() {
    DST_SkillConnectTheme {
        WorkshopsScreen(
            onNavigateBack = {},
            onWorkshopClick = {}
        )
    }
}