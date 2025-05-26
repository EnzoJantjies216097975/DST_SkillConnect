package com.dst511s.dst_skillconnect.unsorted.tka

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarToday
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.Work
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.dst511s.dst_skillconnect.unsorted.data.CompanyProfile

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
