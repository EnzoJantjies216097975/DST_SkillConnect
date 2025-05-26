package com.dst511s.dst_skillconnect.unsorted.tka

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.dst511s.dst_skillconnect.unsorted.data.SkillProgressData

@Composable
fun SkillsProgressSection(skillsData: List<SkillProgressData>) {
    Card(modifier = Modifier.fillMaxWidth()) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "Skills Progress",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(16.dp))

            skillsData.take(5).forEach { skill ->
                SkillProgressItem(skill = skill)
                Spacer(modifier = Modifier.height(8.dp))
            }

            if (skillsData.size > 5) {
                TextButton(
                    onClick = { /* View all skills */ },
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                ) {
                    Text("View All Skills")
                }
            }
        }
    }
}