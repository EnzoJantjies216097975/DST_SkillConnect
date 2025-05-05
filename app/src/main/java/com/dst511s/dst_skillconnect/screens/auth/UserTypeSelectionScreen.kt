package com.dst511s.dst_skillconnect.screens.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Business
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.School
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dst511s.dst_skillconnect.R
import com.dst511s.dst_skillconnect.components.UserTypeOption
import com.dst511s.dst_skillconnect.data.models.UserType
import com.dst511s.dst_skillconnect.ui.theme.DST_SkillConnectTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserTypeSelectionScreen(
    onUserTypeSelected: (UserType) -> Unit
) {
    var selectedUserType by remember { mutableStateOf<UserType?>(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 24.dp, vertical = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(40.dp))

        // Logo
        Box(
            modifier = Modifier
                .size(100.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(MaterialTheme.colorScheme.primary.copy(alpha = 0.1f)),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(id = R.drawable.logo_placeholder),
                contentDescription = "SkillConnect Logo",
                modifier = Modifier.size(60.dp),
                tint = MaterialTheme.colorScheme.primary
            )
        }

        Spacer(modifier = Modifier.height(32.dp))

        // Header text
        Text(
            text = "What best describes you?",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Choose your profile type to customize your experience",
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.7f),
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(40.dp))

        // User type options
        UserTypeOption(
            userType = UserType.JOB_SEEKER,
            icon = Icons.Default.Person,
            title = "Job Seeker",
            description = "Looking for jobs, building skills, and connecting with employers",
            isSelected = selectedUserType == UserType.JOB_SEEKER,
            onClick = { selectedUserType = UserType.JOB_SEEKER }
        )

        Spacer(modifier = Modifier.height(16.dp))

        UserTypeOption(
            userType = UserType.EMPLOYER,
            icon = Icons.Default.Business,
            title = "Employer",
            description = "Posting jobs, reviewing applications, and finding talent",
            isSelected = selectedUserType == UserType.EMPLOYER,
            onClick = { selectedUserType = UserType.EMPLOYER }
        )

        Spacer(modifier = Modifier.height(16.dp))

        UserTypeOption(
            userType = UserType.WORKSHOP_PROVIDER,
            icon = Icons.Default.School,
            title = "Workshop Provider",
            description = "Hosting workshops, training sessions, and skill development programs",
            isSelected = selectedUserType == UserType.WORKSHOP_PROVIDER,
            onClick = { selectedUserType = UserType.WORKSHOP_PROVIDER }
        )

        Spacer(modifier = Modifier.height(32.dp))

        // Note about changes
        Text(
            text = "You can change your profile type later in settings",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.6f),
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.weight(1f))

        // Continue button
        Button(
            onClick = {
                selectedUserType?.let { onUserTypeSelected(it) }
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .padding(vertical = 8.dp),
            shape = RoundedCornerShape(28.dp),
            enabled = selectedUserType != null
        ) {
            Text(
                text = "Continue",
                style = MaterialTheme.typography.titleMedium
            )
        }

        Spacer(modifier = Modifier.height(24.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun UserTypeSelectionScreenPreview() {
    DST_SkillConnectTheme {
        UserTypeSelectionScreen(
            onUserTypeSelected = {}
        )
    }
}