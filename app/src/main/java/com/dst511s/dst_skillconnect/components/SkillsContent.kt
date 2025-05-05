package com.dst511s.dst_skillconnect.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dst511s.dst_skillconnect.data.models.Skill
import com.dst511s.dst_skillconnect.ui.theme.DST_SkillConnectTheme

@Composable
fun SkillsContent(
    skills: List<Skill>,
    onSkillClick: (Skill) -> Unit
) {
    Column {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            skills.take(3).forEach { skill ->
                SkillChip(
                    skill = skill,
                    onClick = { onSkillClick(skill) }
                )
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            skills.drop(3).take(3).forEach { skill ->
                SkillChip(
                    skill = skill,
                    onClick = { onSkillClick(skill) }
                )
            }
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun SkillsContentPreview() {
//    DST_SkillConnectTheme {
//        SkillsContent(
//            skills = listOf(
//                Skill("JavaScript", "Intermediate", true),
//                Skill("HTML/CSS", "Advanced", false),
//                Skill("Python", "Intermediate", false),
//                Skill("React", "Beginner", false)
//            ),
//            onSkillClick = {}
//        )
//    }
//}