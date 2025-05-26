package com.dst511s.dst_skillconnect.unsorted.tka

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AlternateEmail
import androidx.compose.material.icons.filled.Code
import androidx.compose.material.icons.filled.Language
import androidx.compose.material.icons.filled.Link
import androidx.compose.material.icons.filled.Work
import androidx.compose.ui.graphics.vector.ImageVector

fun getSocialIcon(platform: String): ImageVector {
    return when (platform.lowercase()) {
        "github" -> Icons.Default.Code
        "linkedin" -> Icons.Default.Work
        "twitter" -> Icons.Default.AlternateEmail
        "website" -> Icons.Default.Language
        else -> Icons.Default.Link
    }
}