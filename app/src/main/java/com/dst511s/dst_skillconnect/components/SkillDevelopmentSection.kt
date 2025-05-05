package com.dst511s.dst_skillconnect.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dst511s.dst_skillconnect.data.models.SkillProgress

@Composable
fun SkillDevelopmentSection() {
    val skills = remember {
        listOf(
            SkillProgress(
                name = "JavaScript",
                progress = 0.65f,
                level = "Intermediate",
                isVerified = true
            ),
            SkillProgress(
                name = "HTML/CSS",
                progress = 0.8f,
                level = "Advanced",
                isVerified = false
            ),
            SkillProgress(
                name = "React",
                progress = 0.3f,
                level = "Beginner",
                isVerified = false
            )
        )
    }

    Column {
        skills.forEach { skill ->
            SkillProgressItem(skill = skill)
            Spacer(modifier = Modifier.height(16.dp))
        }

        TextButton(
            onClick = { /* Navigate to skills detail */ },
            modifier = Modifier.align(Alignment.End)
        ) {
            Text(
                text = "View All Skills",
                style = MaterialTheme.typography.labelLarge
            )

            Spacer(modifier = Modifier.width(4.dp))

            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                contentDescription = null,
                modifier = Modifier.size(16.dp)
            )
        }
    }
}