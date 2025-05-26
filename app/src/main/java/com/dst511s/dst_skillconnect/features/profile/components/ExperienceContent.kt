package com.dst511s.dst_skillconnect.features.profile.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.dst511s.dst_skillconnect.core.data.models.profile.Experience

@Composable
fun ExperienceContent(
    experiences: List<Experience>
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        experiences.forEach { experience ->
            ExperienceItem(experience = experience)
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun ExperienceContentPreview() {
//    DST_SkillConnectTheme {
//        ExperienceContent(
//            experiences = listOf(
//                Experience("Web Development Intern", "TechStartup Namibia", "Jan 2024 - Mar 2024", false),
//                Experience("Volunteer IT Support", "Community Center", "Oct 2023 - Dec 2023", false)
//            )
//        )
//    }
//}