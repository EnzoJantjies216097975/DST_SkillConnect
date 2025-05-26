package com.dst511s.dst_skillconnect.unsorted.tka

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.dst511s.dst_skillconnect.unsorted.enume.MarketDemand

@Composable
fun MarketDemandChip(demand: MarketDemand) {
    val (color, text) = when (demand) {
        MarketDemand.VERY_HIGH -> Color(0xFF4CAF50) to "🔥"
        MarketDemand.HIGH -> Color(0xFF8BC34A) to "📈"
        MarketDemand.MODERATE -> Color(0xFFFF9800) to "📊"
        MarketDemand.LOW -> Color(0xFF9E9E9E) to "📉"
    }

    Text(
        text = text,
        style = MaterialTheme.typography.bodySmall,
        modifier = Modifier.padding(start = 4.dp)
    )
}