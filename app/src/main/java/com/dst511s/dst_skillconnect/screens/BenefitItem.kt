package com.dst511s.dst_skillconnect.screens

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