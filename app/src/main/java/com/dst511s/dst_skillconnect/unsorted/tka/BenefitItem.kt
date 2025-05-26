package com.dst511s.dst_skillconnect.unsorted.tka

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AttachMoney
import androidx.compose.material.icons.filled.Balance
import androidx.compose.material.icons.filled.CardGiftcard
import androidx.compose.material.icons.filled.LocalHospital
import androidx.compose.material.icons.filled.School
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.dst511s.dst_skillconnect.unsorted.data.CompanyBenefit
import com.dst511s.dst_skillconnect.unsorted.enume.BenefitCategory

@Composable
fun BenefitItem(benefit: CompanyBenefit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = when (benefit.category) {
                BenefitCategory.HEALTH -> Icons.Default.LocalHospital
                BenefitCategory.FINANCIAL -> Icons.Default.AttachMoney
                BenefitCategory.WORK_LIFE_BALANCE -> Icons.Default.Balance
                BenefitCategory.PROFESSIONAL_DEVELOPMENT -> Icons.Default.School
                BenefitCategory.PERKS -> Icons.Default.CardGiftcard
            },
            contentDescription = null,
            modifier = Modifier.size(16.dp),
            tint = MaterialTheme.colorScheme.primary
        )

        Spacer(modifier = Modifier.width(8.dp))

        Column {
            Text(
                text = benefit.title,
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Medium
            )

            if (benefit.description.isNotEmpty()) {
                Text(
                    text = benefit.description,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
                )
            }
        }
    }
}