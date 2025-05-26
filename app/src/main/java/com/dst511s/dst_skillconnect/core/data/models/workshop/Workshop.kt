package com.dst511s.dst_skillconnect.core.data.models.workshop

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector

data class Workshop(
    val id: String,
    val title: String,
    val description: String,
    val date: String,
    val time: String,
    val location: String,
    val isOnline: Boolean,
    val icon: ImageVector,
    val iconBackgroundColor: Color,
    val isRegistered: Boolean
)
