package com.dst511s.dst_skillconnect.screens

@Composable
fun CompanyQuickStats(company: CompanyProfile) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        QuickStat(
            value = company.openPositions.size.toString(),
            label = "Open Jobs",
            icon = Icons.Default.Work
        )

        QuickStat(
            value = "${company.reviews.overallRating}★",
            label = "${company.reviews.totalReviews} Reviews",
            icon = Icons.Default.Star
        )

        QuickStat(
            value = company.locations.size.toString(),
            label = if (company.locations.size == 1) "Location" else "Locations",
            icon = Icons.Default.LocationOn
        )

        QuickStat(
            value = "Founded ${company.foundedYear}",
            label = "${(2025 - company.foundedYear)} years",
            icon = Icons.Default.CalendarToday
        )
    }
}
